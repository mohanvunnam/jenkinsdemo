import ruamel.yaml
from ruamel.yaml.comments import merge_attrib

with open('service.yaml') as f:
    result = ruamel.yaml.round_trip_load(f)

keys_to_delete = []
for k in result:
    v = result[k]
    if v.yaml_anchor():
        keys_to_delete.append(k)
    for merge_data in v.merge:  # update the dict with the merge data 
        v.update(merge_data[1])
        delattr(v, merge_attrib)
for k in keys_to_delete:
    del result[k]

ruamel.yaml.round_trip_dump(result, sys.stdout)
