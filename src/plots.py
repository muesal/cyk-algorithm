
import matplotlib.pyplot as plt

## env: source cyk/bin/activate
## run: python plots.py
## xdg-open plots.png

length = [100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900, 2000, 2100, 2200, 2300, 2400, 2500, 2600, 2700, 2800, 2900, 3000, 3100, 3200, 3300, 3400, 3500, 3600, 3700, 3800, 3900, 4000, 4100, 4200, 4300, 4400, 4500, 4600, 4700, 4800, 4900, 5000]

#Bottom-Up
#((...))
time_bu_1 = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 4, 5, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 18, 19, 21, 23, 25, 27, 29, 31, 34, 36, 39, 41, 44, 47, 50, 53]
counter_bu_1 = [664150, 5323300, 17977450, 42626600, 83270750, 143909900, 228544050, 341173200, 485797350, 666416500, 887030650, 1151639800, 1464243950, 1828843100, 2249437250, 2730026400, 3274610550, 3887189700, 4571763850, 5332333000, 6172897150, 7097456300, 8110010450, 9214559600, 10415103750, 11715642900, 13120177050, 14632706200, 16257230350, 17997749500, 19858263650, 21842772800, 23955276950, 26199776100, 28580270250, 31100759400, 33765243550, 36577722700, 39542196850, 42662666000, 45943130150, 49387589300, 53000043450, 56784492600, 60744936750, 64885375900, 69209810050, 73722239200, 78426663350, 83327082500]

#()..()
time_bu_2 = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 7, 8, 10, 11, 12, 14, 16, 18, 19, 22, 24, 26, 29, 32, 35, 38, 43, 45, 49, 52, 57, 62, 66, 71, 77, 81, 88]
counter_bu_2 = [626175, 5004850, 16886025, 40019700, 78155875, 135044550, 214435725, 320079400, 455725575, 625124250, 832025425, 1080179100, 1373335275, 1715243950, 2109655125, 2560318800, 3070984975, 3645403650, 4287324825, 5000498500, 5788674675, 6655603350, 7605034525, 8640718200, 9766404375, 10985843050, 12302784225, 13720977900, 15244174075, 16876122750, 18620573925, 20481277600, 22461983775, 24566442450, 26798403625, 29161617300, 31659833475, 34296802150, 37076273325, 40001997000, 43077723175, 46307201850, 49694183025, 53242416700, 56955652875, 60837641550, 64892132725, 69122876400, 73533622575, 78128121250]

#)()..() (additional closing bracket)
time_bu_3 = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 7, 8, 10, 11, 12, 14, 16, 18, 19, 22, 24, 26, 29, 32, 35, 38, 40, 44, 49, 52, 57, 61, 66, 71, 75, 80]
counter_bu_3 = [646375, 5085250, 17066625, 40340500, 78656875, 135765750, 215417125, 321361000, 457347375, 627126250, 834447625, 1083061500, 1376717875, 1719166750, 2114158125, 2565442000, 3076768375, 3651887250, 4294548625, 5008502500, 5797498875, 6665287750, 7615619125, 8652243000, 9778909375, 10999368250, 12317369625, 13736663500, 15260999875, 16894128750, 18639800125, 20501764000, 22483770375, 24589569250, 26822910625, 29187544500, 31687220875, 34325689750, 37106701125, 40034005000, 43111351375, 46342490250, 49731171625, 53281145500, 56996161875, 60879970750, 64936322125, 69168966000, 73581652375, 78178131250]

#()..()( (additional opening bracket)
time_bu_4 = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 4, 4, 5, 6, 7, 8, 9, 10, 12, 13, 15, 17, 19, 21, 23, 26, 28, 31, 34, 37, 41, 43, 47, 51, 54, 59, 65, 69, 75, 80, 85]
counter_bu_4 = [646375, 5085250, 17066625, 40340500, 78656875, 135765750, 215417125, 321361000, 457347375, 627126250, 834447625, 1083061500, 1376717875, 1719166750, 2114158125, 2565442000, 3076768375, 3651887250, 4294548625, 5008502500, 5797498875, 6665287750, 7615619125, 8652243000, 9778909375, 10999368250, 12317369625, 13736663500, 15260999875, 16894128750, 18639800125, 20501764000, 22483770375, 24589569250, 26822910625, 29187544500, 31687220875, 34325689750, 37106701125, 40034005000, 43111351375, 46342490250, 49731171625, 53281145500, 56996161875, 60879970750, 64936322125, 69168966000, 73581652375, 78178131250]

#Stupid grammar (a..a)
time_bu_5 = []
counter_bu_5 = []

#Top-Down
# slow cases; new length
#((..)) TODO: adapt time and counter to new length
length_2 = [101, 201, 301, 401, 501, 601, 701, 801, 901, 1001, 1101, 1201, 1301, 1401, 1501, 1601, 1701, 1801, 1901, 2001, 2101, 2201, 2301, 2401, 2501]
time_td_1 = [0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 3, 4, 5, 7, 9, 10, 13, 15, 18, 21, 24, 28, 32, 36, 41, 47, 52, 58, 65, 72, 79, 87, 96, 105, 114, 124, 135, 147, 158, 171, 184, 198, 212, 228, 244, 260, 278, 297, 315, 334]
counter_td_1 = [335800, 2676600, 9022400, 21373200, 41729000, 72089800, 114455600, 170826400, 243202200, 333583000, 443968800, 576359600, 732755400, 915156200, 1125562000, 1365972800, 1638388600, 1944809400, 2287235200, 2667666000, 3088101800, 3550542600, 4056988400, 4609439200, 5209895000, 5860355800, 6562821600, 7319292400, 8131768200, 9002249000, 9932734800, 10925225600, 11981721400, 13104222200, 14294728000, 15555238800, 16887754600, 18294275400, 19776801200, 21337332000, 22977867800, 24700408600, 26506954400, 28399505200, 30380061000, 32450621800, 34613187600, 36869758400, 39222334200, 41672915000]

#()..()( (additional opening bracket)
time_td_4 = [0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 7, 9, 11, 14, 17, 20, 24, 29, 34, 40, 46, 52, 60, 68]
counter_td_4 = [550525, 4368550, 14704075, 34807100, 67927625, 117315650, 186221175, 277894200, 395584725, 542542750, 722018275, 937261300, 1191521825, 1488049850, 1830095375, 2220908400, 2663738925, 3161836950, 3718452475, 4336835500, 5020236025, 5771904050, 6595089575, 7493042600, 8469013125]

# fast cases; Time in Milliseconds, new length
#()..()
length_3 = [100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900, 2000, 2100, 2200, 2300, 2400, 2500, 2600, 2700, 2800, 2900, 3000, 3100, 3200, 3300, 3400, 3500, 3600, 3700, 3800, 3900, 4000, 4100, 4200, 4300, 4400, 4500, 4600, 4700, 4800, 4900, 5000, 5100, 5200, 5300, 5400, 5500, 5600, 5700, 5800, 5900, 6000, 6100, 6200, 6300, 6400, 6500, 6600, 6700, 6800, 6900, 7000, 7100, 7200, 7300, 7400, 7500, 7600, 7700, 7800, 7900, 8000, 8100, 8200, 8300, 8400, 8500, 8600, 8700, 8800, 8900, 9000, 9100, 9200, 9300, 9400, 9500, 9600, 9700, 9800, 9900, 10000]
time_td_2 = [0, 0, 1, 1, 1, 3, 3, 4, 3, 4, 5, 6, 10, 10, 11, 10, 15, 16, 14, 15, 18, 23, 20, 23, 27, 29, 26, 29, 38, 32, 34, 39, 41, 41, 48, 46, 52, 58, 57, 67, 68, 71, 85, 86, 82, 80, 86, 90, 88, 91, 95, 115, 102, 133, 143, 136, 125, 137, 126, 145, 153, 155, 151, 177, 177, 186, 187, 165, 202, 209, 242, 242, 242, 254, 254, 258, 290, 292, 291, 295, 321, 320, 322, 338, 349, 351, 362, 381, 382, 382, 401, 400, 425, 424, 429, 440, 457, 460, 468, 476]
counter_td_2 = [7647, 30297, 67947, 120597, 188247, 270897, 368547, 481197, 608847, 751497, 909147, 1081797, 1269447, 1472097, 1689747, 1922397, 2170047, 2432697, 2710347, 3002997, 3310647, 3633297, 3970947, 4323597, 4691247, 5073897, 5471547, 5884197, 6311847, 6754497, 7212147, 7684797, 8172447, 8675097, 9192747, 9725397, 10273047, 10835697, 11413347, 12005997, 12613647, 13236297, 13873947, 14526597, 15194247, 15876897, 16574547, 17287197, 18014847, 18757497, 19515147, 20287797, 21075447, 21878097, 22695747, 23528397, 24376047, 25238697, 26116347, 27008997, 27916647, 28839297, 29776947, 30729597, 31697247, 32679897, 33677547, 34690197, 35717847, 36760497, 37818147, 38890797, 39978447, 41081097, 42198747, 43331397, 44479047, 45641697, 46819347, 48011997, 49219647, 50442297, 51679947, 52932597, 54200247, 55482897, 56780547, 58093197, 59420847, 60763497, 62121147, 63493797, 64881447, 66284097, 67701747, 69134397, 70582047, 72044697, 73522347, 75014997]

#)()..() (additional closing bracket)
time_td_3 = [0, 1, 2, 4, 4, 6, 8, 11, 11, 14, 16, 18, 23, 24, 28, 32, 37, 41, 46, 53, 57, 61, 69, 72, 81, 95, 96, 100, 114, 122, 121, 130, 144, 147, 175, 178, 191, 183, 202, 206, 232, 235, 253, 272, 275, 302, 297, 314, 327, 338, 345, 370, 393, 382, 416, 428, 431, 461, 465, 485, 519, 508, 533, 559, 555, 587, 610, 623, 648, 667, 693, 712, 720, 736, 760, 791, 805, 822, 857, 884, 902, 914, 944, 969, 995, 1007, 1057, 1088, 1083, 1103, 1134, 1168, 1193, 1206, 1239, 1272, 1300, 1322, 1338, 1381]
counter_td_3 = [15150, 60300, 135450, 240600, 375750, 540900, 736050, 961200, 1216350, 1501500, 1816650, 2161800, 2536950, 2942100, 3377250, 3842400, 4337550, 4862700, 5417850, 6003000, 6618150, 7263300, 7938450, 8643600, 9378750, 10143900, 10939050, 11764200, 12619350, 13504500, 14419650, 15364800, 16339950, 17345100, 18380250, 19445400, 20540550, 21665700, 22820850, 24006000, 25221150, 26466300, 27741450, 29046600, 30381750, 31746900, 33142050, 34567200, 36022350, 37507500, 39022650, 40567800, 42142950, 43748100, 45383250, 47048400, 48743550, 50468700, 52223850, 54009000, 55824150, 57669300, 59544450, 61449600, 63384750, 65349900, 67345050, 69370200, 71425350, 73510500, 75625650, 77770800, 79945950, 82151100, 84386250, 86651400, 88946550, 91271700, 93626850, 96012000, 98427150, 100872300, 103347450, 105852600, 108387750, 110952900, 113548050, 116173200, 118828350, 121513500, 124228650, 126973800, 129748950, 132554100, 135389250, 138254400, 141149550, 144074700, 147029850, 150015000]

#Stupid grammar (a..a)
time_td_5 = []
counter_td_5 = []

#TODO: add measurements (see above), plot all plots
plt.figure()

plt.subplot(211)
plt.title("Average of time in seconds")
plt.xlabel('length')
plt.ylabel('time')
plt.plot(length, time_bu_1, color='r',linestyle='-',label="bottom-up, ((..))")
plt.plot(length, time_bu_2, color='b',linestyle='-',label="bottom-up, ()..()")
plt.legend()

plt.subplot(212)
plt.title("Number of executions of innermost loop")
plt.xlabel('length')
plt.ylabel('counter')
plt.plot(length, counter_bu_1, color='r',linestyle='-',label="bottom-up, (()..))")
plt.plot(length, counter_bu_2, color='b',linestyle='-',label="bottom-up, ()..()")
plt.legend()

plt.subplots_adjust(hspace=0.5)



plt.savefig('plots.jpg')