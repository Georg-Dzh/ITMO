import time
start_time = time.time()
for _ in range(100):
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
                lines.append(f"{k} = {s}")                
            else:
                lines.append(f"{k} = {v}")          

    def setList(name, items):  
        num=1                                 
        for item in items:
            title = f"[{name}_{num}]"       
            lines.append(title)                     
            setProps(item)                          
            lines.append("")
            num+=1                                                 

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

end_time = time.time()
print(f"Время выполнения 100 раз: {end_time - start_time} секунд")
