import time
start_time = time.time()
for _ in range(100):
    class JsonToPython:
        def __init__(self,text):
            self.text = text
            self.pos = 0
            self.length = len(text)

        def SkipProbels(self):
            while self.pos < self.length and self.text[self.pos] in ' \t\n\r':
                self.pos += 1

        def Parse(self):
            self.SkipProbels()
            if self.text[self.pos]=='{':
                return self.ParseObject()
            elif self.text[self.pos]=="[":
                return self.ParseMassiv()
            elif self.text[self.pos]=='"':
                return self.ParseString()
            elif self.text[self.pos]=='t':
                self.pos += 4
                return True
            elif self.text[self.pos]=='f':
                self.pos += 5
                return False
            elif self.text[self.pos]=='n':
                self.pos += 4
                return None
            else:
                return self.ParseNumber()

        def ParseNumber(self):
            StartPos=self.pos
            while self.pos < len(self.text) and self.text[self.pos] in '0123456789.eE+-':
                self.pos += 1
            number=self.text[StartPos:self.pos]
            if '.' in number or 'e' in number or 'E' in number:
                return float(number)
            else:
                return int(number)
            
        def ParseString(self):
            self.pos+=1
            stroka=""
            while self.pos < self.length and self.text[self.pos] != '"':
                if self.text[self.pos]=='\\':
                    self.pos += 1
                    if self.text[self.pos] == '"': stroka += '"'
                    elif self.text[self.pos] == '\\': stroka += '\\'
                    elif self.text[self.pos] == '/': stroka += '/'
                    elif self.text[self.pos] == 'b': stroka += '\b'
                    elif self.text[self.pos] == 'f': stroka += '\f'
                    elif self.text[self.pos] == 'n': stroka += '\n'
                    elif self.text[self.pos] == 'r': stroka += '\r'
                    elif self.text[self.pos] == 't': stroka += '\t'
                    elif self.text[self.pos] == 'u':
                        stroka += chr(int(self.text[self.pos+1 : self.pos+5], 16))
                        self.pos += 4
                    self.pos += 1
                else:
                    stroka+=self.text[self.pos]
                    self.pos+=1
            self.pos+=1
            return stroka
        
        def ParseMassiv(self):
            self.pos+=1
            massiv=[]
            self.SkipProbels()
            while self.text[self.pos] != ']':
                massiv.append(self.Parse())
                self.SkipProbels()
                if self.text[self.pos] == ',':
                    self.pos += 1
                    self.SkipProbels()
            self.pos += 1
            return massiv      

        def ParseObject(self):
            self.pos+=1
            object={}
            self.SkipProbels()
            while self.text[self.pos]!='}':
                key=self.ParseString()
                self.SkipProbels()
                self.pos+=1
                self.SkipProbels()
                object[key]=self.Parse()
                self.SkipProbels()
                if self.text[self.pos] == ',':
                    self.pos += 1
                    self.SkipProbels()
            self.pos+=1
            return object    


    class PythonToIni:
        def __init__(self, data):
            self.data = data

        def Serialize(self):
            result = ""
            if not isinstance(self.data, dict):
                result += "[root]\n"
                result += f"value = {self._format_value(self.data)}\n"
                return result

            for key, value in self.data.items():
                if isinstance(value, list):
                    if len(value) > 0 and isinstance(value[0], dict):
                        index = 1
                        for item in value:
                            result += f"[{key}_{index}]\n"
                            for k, v in item.items():
                                result += f"{k} = {self._format_value(v)}\n"
                            result += "\n"
                            index += 1
                    else:
                        result += f"{key} = {', '.join(self._format_value(x) for x in value)}\n"
                
                elif isinstance(value, dict):
                    result += f"[{key}]\n"
                    for k, v in value.items():
                        result += f"{k} = {self._format_value(v)}\n"
                    result += "\n"
                
                else:
                    result += f"{key} = {self._format_value(value)}\n"
                    
            return result

        def _format_value(self, val):
            if val is True: return "true"
            if val is False: return "false"
            if val is None: return "null"
            return str(val)


    file_in = open("schedule.json", "r", encoding="utf-8")
    json_text = file_in.read()
    file_in.close()

    parser = JsonToPython(json_text).Parse()
    serializer = PythonToIni(parser).Serialize()
            
    file_out = open("schedule.ini", "w", encoding="utf-8")
    file_out.write(serializer)
    file_out.close()
            
    print("Конвертация завершена! Файл schedule.ini создан.")
end_time = time.time()
print(f"Время выполнения 100 раз: {end_time - start_time} секунд")    