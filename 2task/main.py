import pathlib
import hashlib

strings = []

for path in pathlib.Path("/home/vladimir/Downloads/files").iterdir():
    if path.is_file():
        with open(path, 'rb') as f:
            fileData = f.read()
        s = hashlib.sha3_256(fileData).hexdigest()
        strings.append(s)

strings.sort()
a = ''

for st in strings:
    a = a + st

a = hashlib.sha3_256((a + 'sechko101@gmail.com').encode('utf-8')).hexdigest()

print(a)
