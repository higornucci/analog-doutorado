#!/bin/bash
echo Compactando com LZW
for i in chromosome4.txt;
do
	echo $i
	for j in $(seq 1 10);
	do
		java -Xmx7168M LZW2 - $i < arquivos/$i > compactados_lzw/$i
	done
done
