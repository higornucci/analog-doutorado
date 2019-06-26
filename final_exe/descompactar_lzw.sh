#!/bin/bash
echo Descompactando com LZW
for i in pi-1million.txt lilwomen.txt mobydick.txt world192.txt war+peace.txt bible.txt ecoli.txt chromosome11.txt pi-10million.txt chromosome4.txt;
do
	echo $i
	for j in $(seq 1 10);
	do
		java -Xmx7168M LZW2 + $i < compactados_lzw/$i > descompactados_lzw/$i
	done
done