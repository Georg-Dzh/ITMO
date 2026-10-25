def ParseJson(json_str):
    pos = 0 
    def SkipProbels():
        nonlocal pos
        while pos < len(json_str) and json_str[pos] in ' \t\n\r,':
            pos += 1

    def ParseValue():
        nonlocal pos
        SkipProbels()
        if pos >= len(json_str):
            return None
        char = json_str[pos]
        if char == '{':
            return ParseObject()
        elif char == '[':
            return ParseArray()
        elif char == '"':
            return ParseString()
        elif char.isdigit() or char == '-':
            return ParseNumber()
        elif char == 't':
            pos += 4
            return True
        elif char == 'f':
            pos += 5
            return False  
        elif char == 'n':
            return None    
        return None

    def ParseString():
        nonlocal pos
        pos += 1 
        StartPosition = pos
        while pos < len(json_str) and json_str[pos] != '"':
            pos += 1  
        TextRes = json_str[StartPosition:pos]
        pos += 1 
        return TextRes

    def ParseNumber():
        nonlocal pos
        StarPosition = pos
        while pos < len(json_str) and json_str[pos] in '0123456789.-':
            pos += 1
        Number = json_str[StarPosition:pos]
        if '.' in Number:
            return float(Number)
        else:
            return int(Number)
        
    def ParseArray():
        nonlocal pos
        pos += 1 
        result_list = []
        while json_str[pos] != ']':
            element = ParseValue()
            if element is not None:
                result_list.append(element)
            SkipProbels()   
        pos += 1
        return result_list

    def ParseObject():
        nonlocal pos
        pos += 1
        Obj = {}
        SkipProbels()
        while json_str[pos] != '}':
            Key = ParseString()
            SkipProbels()
            pos += 1 
            Obj[Key] = ParseValue()
            SkipProbels()
        pos+=1    
        return Obj

    return ParseValue()
JsonFile=open("schedule.json", "r", encoding="utf-8").read()
final_parsed_object = ParseJson(JsonFile)
import pickle
Deserealization=open("intermediate", "wb").write(pickle.dumps(final_parsed_object))
print("Десериализация успешно завершена! Создан файл intermediate")