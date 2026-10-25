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
        else:
            lines.append(f"{k} = {v}")          

def setList(name, items):
    num = 1                                    
    for item in items:
        title = f"[{name} Lesson{num}]"          
        lines.append(title)                     
        setProps(item)                          
        lines.append("")                        
        num += 1                               

def convert(data):
    for k in data:
        v = data[k]                             
        if isinstance(v, list):
            setList(k, v)                       
        elif isinstance(v, dict):
            lines.append(f"[{k}]")              
            setProps(v)                         
            lines.append("")                    

import pickle
binary_content = open("intermediate", "rb").read()                                                               
data = pickle.loads(binary_content)                                
convert(data)                                   
out = ""                                        
for i in range(len(lines)):
    out += lines[i]                             
    if i < len(lines) - 1:
        out += "\n"                            
fOut = open("schedule.ini", "w", encoding="utf-8").write(out)
print("Сериализация в INI успешно завершена!")