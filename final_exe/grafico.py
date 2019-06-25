import matplotlib.pyplot as plt

barra_lado = True
barra_cima = False
width_bar = 0.35
plt.figure(figsize=(16, 9))
#plt.subplots_adjust(left=0.05, bottom=0.05, right=0.05, top=0.05)
plt.rcParams.update({'font.size': 19})

#arquivos = ['amendments.txt', 'manifesto.txt', 'magna-carta.txt', 'bush-kerry1.txt', 'bush-kerry3.txt', 'obama-mccain3.txt', 'obama-mccain2.txt', 'obama-mccain1.txt', 'bush-kerry2.txt', 'muchado.txt', 'aesop.txt', 'TomSawyer.txt', 'tale.txt', 'pi-1million.txt', 'lilwomen.txt', 'mobydick.txt', 'world192.txt', 'war+peace.txt', 'bible.txt', 'ecoli.txt', 'chromosome11.txt', 'pi-10million.txt', 'chromosome4.txt', 'dickens.txt']
#normal = [18369, 72955, 79702, 84336, 86895, 87369, 89880, 92497, 94371, 123413, 191943, 416145, 797352, 1000000, 1042048, 1191463, 2473400, 3202941, 4047392, 4638690, 7134168, 10000000, 10404835]#, 28965453]
#compactado = [8168, 33912, 36974, 40533, 42350, 41465, 42425, 44316, 45738, 61437, 91703, 206985, 404156, 466571, 497988, 597060, 1569254, 1589240, 1851245, 1254984, 1996523, 5000000, 5000000]  #, 10000000]

arquivos = ['pi-1million.txt', 'lilwomen.txt', 'mobydick.txt', 'world192.txt', 'war+peace.txt', 'bible.txt', 'ecoli.txt', 'chromosome11.txt', 'pi-10million.txt', 'chromosome4.txt']
normal = [1000000, 1042048, 1191463, 2473400, 3202941, 4047392, 4638690, 7134168, 10000000, 10404835]
compactado = [466571, 497988, 597060, 1569254, 1589240, 1851245, 1254984, 1996523, 5000000, 5000000]

perc = []
for i in range(0, len(normal)):
	perc.append(round(compactado[i] / normal[i], 2))

if barra_lado:
	normal_pos = []
	for i in range(0, len(normal)):
		normal_pos.append(i - width_bar / 2)

	compactado_pos = []
	for i in range(0, len(normal)):
		compactado_pos.append(i + width_bar / 2)

	plt.bar(x=normal_pos, height=normal, width=width_bar)
	plt.bar(x=compactado_pos, height=compactado, width=width_bar)

	for x, y, z in zip(list(range(0, len(normal))), normal, perc):
		plt.text(x, y + 0.05, '%.2f' % z, ha='center', va='bottom')

	plt.xticks(normal_pos, arquivos, rotation=45)
	plt.xlabel('Arquivo')
	plt.ylabel('Tamanho (bytes)')
	plt.legend(['Normal', 'Compactado'])
	plt.show()

if barra_cima:
	plt.bar(x=list(range(0, len(normal))), height=normal)
	plt.bar(x=list(range(0, len(compactado))), height=compactado)

	for x, y, z in zip(list(range(0, len(normal))), normal, perc):
		plt.text(x, y + 0.05, '%.2f' % z, ha='center', va='bottom')

	plt.xticks(list(range(0, len(normal))), arquivos, rotation=45)
	plt.xlabel('Arquivo')
	plt.ylabel('Tamanho (bytes)')
	plt.legend(['Normal', 'Compactado'])
	plt.show()