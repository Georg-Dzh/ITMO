import json
import configparser

def convertWithLib():
    with open("schedule.json", "r", encoding="utf-8") as f:
        data = json.load(f)
        
    config = configparser.ConfigParser()
    
    if not isinstance(data, dict):
        config["root"] = {"value": str(data)}
    else:
        for key, itemlist in data.items():
            if isinstance(itemlist, list):
                if len(itemlist) > 0 and isinstance(itemlist[0], dict):
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
                else:
                    config[key] = {"value": ", ".join(str(x) for x in itemlist)}
            elif isinstance(itemlist, dict):
                config[key] = {}
                for k, v in itemlist.items():
                    if isinstance(v, list):
                        config[key][k] = ", ".join(str(x) for x in v)
                    else:
                        config[key][k] = str(v)
            else:
                config[key] = {"value": str(itemlist)}
                
    with open("schedule.ini", "w", encoding="utf-8") as fOut:
        config.write(fOut)

convertWithLib()
print("Конвертация с использованием библиотек успешно завершена!")