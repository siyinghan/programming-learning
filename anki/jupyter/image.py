# Jupyter
import os
from PIL import Image

infile = "test.png"
new_size = (16, 16)

f,e = os.path.splitext(infile)
outfile = f + '_out' + e

with Image.open(infile) as img:
    img.thumbnail(new_size)
    img.save(outfile)
    print(img.size)