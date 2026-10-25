import pickle

lines = []                                   

def listToStr(lst):
    res = ""                                    
    for i in range(len(lst)):
        res += str(lst[i])                      
        if i < len(lst) - 1:
            res += ", "                         
    return res                                  

def setProps(obj):
    for k in obj:
        v = obj[k]                             
        if isinstance(v, list):
            s = listToStr(v)
            lines.append(f"            <{k}>{s}</{k}>")
        else:
            lines.append(f"            <{k}>{v}</{k}>")          

def setList(name, items):
    lines.append(f"    <{name}>")
    for item in items:
        lines.append("        <lesson>")          
        setProps(item)                          
        lines.append("        </lesson>")                        
    lines.append(f"    </{name}>")

def convert(data):
    lines.append('<?xml version="1.0" encoding="utf-8"?>')
    lines.append("<schedule>")
    
    for k in data:
        v = data[k]                             
        if isinstance(v, list):
            setList(k, v)                       
        elif isinstance(v, dict):
            lines.append(f"    <{k}>")              
            setProps(v)                         
            lines.append(f"    </{k}>")              
            
    lines.append("</schedule>")

binary_content = open("intermediate", "rb").read()                                                               
data = pickle.loads(binary_content)                                

convert(data)                                   

out = ""                                        
for i in range(len(lines)):
    out += lines[i]                             
    if i < len(lines) - 1:
        out += "\n"                            

# Записываем результат в файл schedule.xml
fOut = open("schedule.xml", "w", encoding="utf-8").write(out)
print("Сериализация в XML успешно завершена!")
