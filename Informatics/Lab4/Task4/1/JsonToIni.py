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
            while self.pos < len(self.text) and self.text[self.pos] in '0123456789.eE-':
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
                    if self.text[self.pos] == '"': 
                        stroka += '"'
                    elif self.text[self.pos] == '\\': 
                        stroka += '\\'
                    elif self.text[self.pos] == '/': 
                        stroka += '/'
                    elif self.text[self.pos] == 'b': 
                        stroka += '\b'
                    elif self.text[self.pos] == 'f': 
                        stroka += '\f'
                    elif self.text[self.pos] == 'n': 
                        stroka += '\n'
                    elif self.text[self.pos] == 'r': 
                        stroka += '\r'
                    elif self.text[self.pos] == 't':
                        stroka += '\t'
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
            for key, itemlist in self.data.items():
                if isinstance(itemlist, list):
                    index = 1
                    for itemdict in itemlist:
                        result += f"[{key}_{index}]\n"
                        for k, v in itemdict.items():
                            if isinstance(v, list):
                                result += f"{k} = {', '.join(str(x) for x in v)}\n"
                            else:
                                result += f"{k} = {v}\n"
                        result += "\n"
                        index += 1
                elif isinstance(itemlist, dict):
                    result += f"[{key}]\n"
                    for k, v in itemlist.items():
                        result += f"{k} = {v}\n"
                    result += "\n"
                else:
                    result += f"{key} = {itemlist}\n"
            return result


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