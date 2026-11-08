import time
import json
import configparser


# 1. ПАРСЕР (Обязательное задание)

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


# 2. КОНВЕРТЕР В INI (Доп. 1)

class PythonToIni:
    def __init__(self, data):
        self.data = data

    def Serialize(self):
        result = ""
        if not isinstance(self.data, dict):
            return f"[root]\nvalue = {self._format_value(self.data)}\n"

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


# 3. КОНВЕРТЕР В XML (Доп. 3)
class PythonToXml:
    def __init__(self, data):
        self.data = data

    def Serialize(self, root_name="root"):
        result = f'<?xml version="1.0" encoding="UTF-8"?>\n<{root_name}>\n'
        result += self._build_xml(self.data, indent=1)
        result += f'</{root_name}>'
        return result

    def _build_xml(self, obj, indent):
        spaces = "  " * indent
        result = ""

        if isinstance(obj, dict):
            for key, value in obj.items():
                if isinstance(value, list):
                    if len(value) > 0 and isinstance(value[0], dict):
                        for i, item in enumerate(value, 1):
                            result += f"{spaces}<{key}_{i}>\n"
                            result += self._build_xml(item, indent + 1)
                            result += f"{spaces}</{key}_{i}>\n"
                    else:
                        joined = ", ".join(str(x) for x in value)
                        result += f"{spaces}<{key}>{self._escape(joined)}</{key}>\n"
                elif isinstance(value, dict):
                    result += f"{spaces}<{key}>\n"
                    result += self._build_xml(value, indent + 1)
                    result += f"{spaces}</{key}>\n"
                else:
                    result += f"{spaces}<{key}>{self._escape(value)}</{key}>\n"
        elif isinstance(obj, list):
            for i, item in enumerate(obj, 1):
                result += f"{spaces}<item_{i}>\n"
                result += self._build_xml(item, indent + 1)
                result += f"{spaces}</item_{i}>\n"
        else:
            result += f"{spaces}{self._escape(obj)}\n"

        return result

    def _escape(self, val):
        text = str(val).replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
        return text



file_in = open("schedule.json", "r", encoding="utf-8")
json_text = file_in.read()
file_in.close()
N = 100

# 1. Парсинг (Обязательное)
start = time.perf_counter()
for i in range(N):
    parsed_data = JsonToPython(json_text).Parse()
print(f"1. Парсинг (Обязательное): {time.perf_counter() - start:.5f} сек.")

# 2. Сериализация в INI (Доп. 1)
start = time.perf_counter()
for i in range(N):
    PythonToIni(parsed_data).Serialize()
print(f"2. Сериализация INI (Доп. 1): {time.perf_counter() - start:.5f} сек.")

# 3. Сериализация в XML (Доп. 3)
start = time.perf_counter()
for i in range(N):
    PythonToXml(parsed_data).Serialize()
print(f"3. Сериализация XML (Доп. 3): {time.perf_counter() - start:.5f} сек.")

# 4. Библиотеки (Доп. 2)
start = time.perf_counter()
for i in range(N):
    lib_data = json.loads(json_text)
    config = configparser.ConfigParser()
    for key, itemlist in lib_data.items():
        if isinstance(itemlist, list):
            index = 1
            for itemdict in itemlist:
                secName = f"{key}_{index}" 
                config[secName] = {}
                for k, v in itemdict.items():
                    if isinstance(v, list):
                        config[secName][k] = ", ".join(str(x) for x in v)
                    else:
                        config[secName][k] = str(v)
                index += 1
print(f"4. Библиотеки (Доп. 2): {time.perf_counter() - start:.5f} сек.")