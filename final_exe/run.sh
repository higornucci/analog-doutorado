#!/bin/bash
echo Exec6
for i in amendments.txt manifesto.txt magna-carta.txt bush-kerry1.txt bush-kerry3.txt obama-mccain3.txt obama-mccain2.txt obama-mccain1.txt bush-kerry2.txt muchado.txt aesop.txt TomSawyer.txt tale.txt pi-1million.txt lilwomen.txt mobydick.txt world192.txt war+peace.txt bible.txt ecoli.txt chromosome11.txt pi-10million.txt chromosome4.txt dickens.txt;
do
	echo $i
	for j in $(seq 1 1);
	do
		nohup java -Xmx7168M Exec6 - < ../../arquivos4/$i > comprimidos/$i
	done
done