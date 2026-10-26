import json                               
import configparser                           

def listToStr(lst):
    res = ""                                   
    for i in range(len(lst)):
        res += str(lst[i])                      
        if i < len(lst) - 1:
            res += ", "                         
    return res                                  

def convertWithLib():
    jsonTxt = open("schedule.json", "r", encoding="utf-8").read()
    data = json.loads(jsonTxt)              
    config = configparser.ConfigParser()
    for key, itemlist in data.items():
        if isinstance(itemlist, list):
            index=1
            for itemdict in itemlist:
                secName = f"{key}_{index}"
                config[secName] = {}            
                
                for k, v in itemdict.items():
                    if isinstance(v, list):
                        config[secName][k] = listToStr(v)
                    else:
                        config[secName][k] = str(v)
                index+=1        
                
    fOut = open("schedule.ini", "w", encoding="utf-8")
    config.write(fOut)                         

convertWithLib()
print("Конвертация с использованием библиотек успешно завершена!")
