
import matplotlib.pyplot as plt

## env: source cyk/bin/activate
## run: python plots.py
## xdg-open plots.png
length = range(100,5100,100)
length_2 = range(100,2600,100)
length_3 = range(100,11000,100)


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

# bottom up with different order (for ()..())
time_bu_5 = [6, 5, 17, 47, 99, 123, 195, 285, 385, 549, 711, 930, 1104, 1370, 1724, 2283, 2678, 3217, 3871, 4437, 5455, 6372, 6539, 7452, 8583]
counter_bu_5 = [626175, 5004850, 16886025, 40019700, 78155875, 135044550, 214435725, 320079400, 455725575, 625124250, 832025425, 1080179100, 1373335275, 1715243950, 2109655125, 2560318800, 3070984975, 3645403650, 4287324825, 5000498500, 5788674675, 6655603350, 7605034525, 8640718200, 9766404375]

#Top-Down
# slow cases; new length (100 - 2500)
time_td_1 = [0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 3, 4, 5, 7, 9, 10, 13, 15, 18, 21, 24, 28, 32, 36, 41] #, 47, 52, 58, 65, 72, 79, 87, 96, 105, 114, 124, 135, 147, 158, 171, 184, 198, 212, 228, 244, 260, 278, 297, 315, 334]
counter_td_1 = [335800, 2676600, 9022400, 21373200, 41729000, 72089800, 114455600, 170826400, 243202200, 333583000, 443968800, 576359600, 732755400, 915156200, 1125562000, 1365972800, 1638388600, 1944809400, 2287235200, 2667666000, 3088101800, 3550542600, 4056988400, 4609439200, 5209895000] #, 5860355800, 6562821600, 7319292400, 8131768200, 9002249000, 9932734800, 10925225600, 11981721400, 13104222200, 14294728000, 15555238800, 16887754600, 18294275400, 19776801200, 21337332000, 22977867800, 24700408600, 26506954400, 28399505200, 30380061000, 32450621800, 34613187600, 36869758400, 39222334200, 41672915000]

#()..()( (additional opening bracket)
time_td_4 = [0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 7, 9, 11, 14, 17, 20, 24, 29, 34, 40, 46, 52, 60, 68]
counter_td_4 = [550525, 4368550, 14704075, 34807100, 67927625, 117315650, 186221175, 277894200, 395584725, 542542750, 722018275, 937261300, 1191521825, 1488049850, 1830095375, 2220908400, 2663738925, 3161836950, 3718452475, 4336835500, 5020236025, 5771904050, 6595089575, 7493042600, 8469013125]

# fast cases; Time in Milliseconds, new length (100 - 10000)
#()..()
time_td_2 = [0, 0, 1, 1, 1, 3, 3, 4, 3, 4, 5, 6, 10, 10, 11, 10, 15, 16, 14, 15, 18, 23, 20, 23, 27, 29, 26, 29, 38, 32, 34, 39, 41, 41, 48, 46, 52, 58, 57, 67, 68, 71, 85, 86, 82, 80, 86, 90, 88, 91, 95, 115, 102, 133, 143, 136, 125, 137, 126, 145, 153, 155, 151, 177, 177, 186, 187, 165, 202, 209, 242, 242, 242, 254, 254, 258, 290, 292, 291, 295, 321, 320, 322, 338, 349, 351, 362, 381, 382, 382, 401, 400, 425, 424, 429, 440, 457, 460, 468, 476]
counter_td_2 = [7647, 30297, 67947, 120597, 188247, 270897, 368547, 481197, 608847, 751497, 909147, 1081797, 1269447, 1472097, 1689747, 1922397, 2170047, 2432697, 2710347, 3002997, 3310647, 3633297, 3970947, 4323597, 4691247, 5073897, 5471547, 5884197, 6311847, 6754497, 7212147, 7684797, 8172447, 8675097, 9192747, 9725397, 10273047, 10835697, 11413347, 12005997, 12613647, 13236297, 13873947, 14526597, 15194247, 15876897, 16574547, 17287197, 18014847, 18757497, 19515147, 20287797, 21075447, 21878097, 22695747, 23528397, 24376047, 25238697, 26116347, 27008997, 27916647, 28839297, 29776947, 30729597, 31697247, 32679897, 33677547, 34690197, 35717847, 36760497, 37818147, 38890797, 39978447, 41081097, 42198747, 43331397, 44479047, 45641697, 46819347, 48011997, 49219647, 50442297, 51679947, 52932597, 54200247, 55482897, 56780547, 58093197, 59420847, 60763497, 62121147, 63493797, 64881447, 66284097, 67701747, 69134397, 70582047, 72044697, 73522347, 75014997]

#)()..() (additional closing bracket)
time_td_3 = [0, 1, 2, 4, 4, 6, 8, 11, 11, 14, 16, 18, 23, 24, 28, 32, 37, 41, 46, 53, 57, 61, 69, 72, 81, 95, 96, 100, 114, 122, 121, 130, 144, 147, 175, 178, 191, 183, 202, 206, 232, 235, 253, 272, 275, 302, 297, 314, 327, 338, 345, 370, 393, 382, 416, 428, 431, 461, 465, 485, 519, 508, 533, 559, 555, 587, 610, 623, 648, 667, 693, 712, 720, 736, 760, 791, 805, 822, 857, 884, 902, 914, 944, 969, 995, 1007, 1057, 1088, 1083, 1103, 1134, 1168, 1193, 1206, 1239, 1272, 1300, 1322, 1338, 1381]
counter_td_3 = [15150, 60300, 135450, 240600, 375750, 540900, 736050, 961200, 1216350, 1501500, 1816650, 2161800, 2536950, 2942100, 3377250, 3842400, 4337550, 4862700, 5417850, 6003000, 6618150, 7263300, 7938450, 8643600, 9378750, 10143900, 10939050, 11764200, 12619350, 13504500, 14419650, 15364800, 16339950, 17345100, 18380250, 19445400, 20540550, 21665700, 22820850, 24006000, 25221150, 26466300, 27741450, 29046600, 30381750, 31746900, 33142050, 34567200, 36022350, 37507500, 39022650, 40567800, 42142950, 43748100, 45383250, 47048400, 48743550, 50468700, 52223850, 54009000, 55824150, 57669300, 59544450, 61449600, 63384750, 65349900, 67345050, 69370200, 71425350, 73510500, 75625650, 77770800, 79945950, 82151100, 84386250, 86651400, 88946550, 91271700, 93626850, 96012000, 98427150, 100872300, 103347450, 105852600, 108387750, 110952900, 113548050, 116173200, 118828350, 121513500, 124228650, 126973800, 129748950, 132554100, 135389250, 138254400, 141149550, 144074700, 147029850, 150015000]

# top down fast case with different order of the rules
time_td_5 = [8, 26, 74, 131, 249, 424, 675, 1008, 1434, 1970, 2624, 3398, 4323, 5388, 6642, 8060, 9635, 11463, 15210, 15717, 19104, 20960, 24017, 28209, 30912]
counter_td_5 = [246669, 1985844, 6717519, 15941694, 31158369, 53867544, 85569219, 127763394, 181950069, 249629244, 332300919, 431465094, 548621769, 685270944, 842912619, 1023046794, 1227173469, 1456792644, 1713404319, 1998508494, 2313605169, 2660194344, 3039776019, 3453850194, 3903916869]

#Stupid grammar (a..a)
length_sg = [100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900, 2000, 2100, 2200, 2300, 2400, 2500]
time_bu_sg = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 3]
counter_bu_sg = [333300, 2666600, 8999900, 21333200, 41666500, 71999800, 114333100, 170666400, 242999700, 333333000, 443666300, 575999600, 732332900, 914666200, 1124999500, 1365332800, 1637666100, 1943999400, 2286332700, 2666666000, 3086999300, 3549332600, 4055665900, 4607999200, 5208332500]

time_td_sg = [0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 3, 4, 5, 7, 9, 11, 13, 15, 19, 21, 25, 29, 33, 37, 42]
counter_td_sg = [333300, 2666600, 8999900, 21333200, 41666500, 71999800, 114333100, 170666400, 242999700, 333333000, 443666300, 575999600, 732332900, 914666200, 1124999500, 1365332800, 1637666100, 1943999400, 2286332700, 2666666000, 3086999300, 3549332600, 4055665900, 4607999200, 5208332500]

# strings starting (sa) and ending (ea) in a, bottom up, ms
#input: ab..ab resp. ba..ba
time_bu_sa = [1, 4, 6, 5, 12, 20, 37, 38, 52, 59, 73, 94, 117, 145, 177, 211, 251, 297, 350, 404, 466, 533, 606, 686, 808]
counter_bu_sa = [89525, 691550, 2306075, 5433100, 10572625, 18224650, 28889175, 43066200, 61255725, 83957750, 111672275, 144899300, 184138825, 229890850, 282655375, 342932400, 411221925, 488023950, 573838475, 669165500, 774505025, 890357050, 1017221575, 1155598600, 1305988125]
time_bu_ea = [2, 3, 11, 27, 64, 103, 133, 212, 303, 429, 561, 727, 917, 1032, 1292, 1575, 1922, 2392, 2903, 3268, 3836, 4993, 5658, 6459, 7684]
counter_bu_ea = [171600, 1353200, 4544800, 10746400, 20958000, 36179600, 57411200, 85652800, 121904400, 167166000, 222437600, 288719200, 367010800, 458312400, 563624000, 683945600, 820277200, 973618800, 1144970400, 1335332000, 1545703600, 1777085200, 2030476800, 2306878400, 2607290000]

# strings starting (sa) and ending (ea) in a, bottom up, with wrong input, ms
#input: ba..ba resp. ab..ab
time_bu_sa_w = [0, 2, 3, 6, 11, 17, 28, 36, 62, 67, 80, 97, 122, 152, 194, 222, 272, 315, 384, 446, 538, 573, 614, 692, 777]
counter_bu_sa_w = [91975, 701450, 2328425, 5472900, 10634875, 18314350, 29011325, 43225800, 61457775, 84207250, 111974225, 145258700, 184560675, 230380150, 283217125, 343571600, 411943575, 488833050, 574740025, 670164500, 775606475, 891565950, 1018542925, 1157037400, 1307549375]
time_bu_ea_w = [3, 5, 16, 25, 52, 90, 126, 187, 278, 369, 512, 642, 826, 1084, 1376, 1666, 2057, 2480, 3040, 3560, 4292, 4759, 5934, 6945, 6846]
counter_bu_ea_w = [171600, 1353200, 4544800, 10746400, 20958000, 36179600, 57411200, 85652800, 121904400, 167166000, 222437600, 288719200, 367010800, 458312400, 563624000, 683945600, 820277200, 973618800, 1144970400, 1335332000, 1545703600, 1777085200, 2030476800, 2306878400, 2607290000]

# TODO: control all of them maybe run them for length 100 and check counter times.
#input:aa..bb (length: starting 5000, ending 2500)
time_bu_sa_ser = [0, 1, 2, 4, 5, 8, 12, 19, 23, 28, 35, 43, 53, 64, 76, 91, 107, 124, 144, 165, 190, 213, 241, 271, 302, 336, 373, 423, 460, 512, 559, 609, 650, 722, 772, 834, 907, 975, 1049, 1120, 1201, 1279, 1364, 1451, 1552, 1662, 1761, 1869, 1992, 2092]
counter_bu_sa_ser = [29500, 201500, 641000, 1473000, 2822500, 4814500, 7574000, 11226000, 15895500, 21707500, 28787000, 37259000, 47248500, 58880500, 72280000, 87572000, 104881500, 124333500, 146053000, 170165000, 196794500, 226066500, 258106000, 293038000, 330987500, 372079500, 416439000, 464191000, 515460500, 570372500, 629052000, 691624000, 758213500, 828945500, 903945000, 983337000, 1067246500, 1155798500, 1249118000, 1347330000, 1450559500, 1558931500, 1672571000, 1791603000, 1916152500, 2046344500, 2182304000, 2324156000, 2472025500, 2626037500]
time_bu_se_ser_w = [2, 4, 12, 29, 51, 75, 120, 178, 264, 373, 483, 630, 819, 1089, 1581, 1950, 2034, 2479, 3042, 3524, 4213, 4947, 5610, 6382, 7853]
counter_bu_se_ser_w = [171600, 1353200, 4544800, 10746400, 20958000, 36179600, 57411200, 85652800, 121904400, 167166000, 222437600, 288719200, 367010800, 458312400, 563624000, 683945600, 820277200, 973618800, 1144970400, 1335332000, 1545703600, 1777085200, 2030476800, 2306878400, 2607290000]
#TODO: this counter is exactly the same as counter counter_bu_ea_w. Compare other counters too
#input: bb..aa (length: starting 5000, ending 2500)
time_bu_sa_ser_w = [1, 3, 4, 7, 19, 25, 33, 47, 65, 88, 115, 148, 187, 230, 283, 339, 406, 481, 563, 656, 757, 869, 992, 1122, 1268, 1424, 1591, 1779, 1981, 2185, 2412, 2645, 2904, 3168, 3452, 3760, 4081, 4420, 4787, 5160, 5535, 5982, 6413, 6902, 7426, 7931, 8500, 9072, 9707, 10316]
counter_bu_sa_ser_w = [152000, 1191500, 3993500, 9433000, 18385000, 31724500, 50326500, 75066000, 106818000, 146457500, 194859500, 252899000, 321451000, 401390500, 493592500, 598932000, 718284000, 852523500, 1002525500, 1169165000, 1353317000, 1555856500, 1777658500, 2019598000, 2282550000, 2567389500, 2874991500, 3206231000, 3561983000, 3943122500, 4350524500, 4785064000, 5247616000, 5739055500, 6260257500, 6812097000, 7395449000, 8011188500, 8660190500, 9343330000, 10061482000, 10815521500, 11606323500, 12434763000, 13301715000, 14208054500, 15154656500, 16142396000, 17172148000, 18244787500]
time_bu_se_ser = [1, 2, 5, 9, 14, 29, 33, 46, 65, 88, 117, 149, 187, 232, 284, 340, 408, 483, 567, 659, 762, 876, 995, 1125, 1269, 1425, 1596, 1786, 1983, 2182, 2422, 2648, 2905, 3180, 3454, 3765, 4086, 4434, 4788, 5175, 5566, 5993, 6440, 6913, 7432, 7958, 8507, 9119, 9749, 10340]
counter_bu_se_ser = [152000, 1191500, 3993500, 9433000, 18385000, 31724500, 50326500, 75066000, 106818000, 146457500, 194859500, 252899000, 321451000, 401390500, 493592500, 598932000, 718284000, 852523500, 1002525500, 1169165000, 1353317000, 1555856500, 1777658500, 2019598000, 2282550000, 2567389500, 2874991500, 3206231000, 3561983000, 3943122500, 4350524500, 4785064000, 5247616000, 5739055500, 6260257500, 6812097000, 7395449000, 8011188500, 8660190500, 9343330000, 10061482000, 10815521500, 11606323500, 12434763000, 13301715000, 14208054500, 15154656500, 16142396000, 17172148000, 18244787500]


# strings starting (sa) and ending (ea) in a, top down, ms
# input: ab..ab resp. ba..ba
# fast case
time_td_sa = [0, 0, 0, 0, 1, 1, 2, 1, 2, 2, 3, 5, 4, 5, 6, 8, 6, 7, 9, 10, 10, 11, 14, 13, 15, 16, 17, 17, 21, 21, 20, 26, 25, 26, 28, 32, 32, 33, 34, 37, 38, 40, 41, 45, 48, 51, 52, 57, 54, 58]
counter_td_sa = [199, 399, 599, 799, 999, 1199, 1399, 1599, 1799, 1999, 2199, 2399, 2599, 2799, 2999, 3199, 3399, 3599, 3799, 3999, 4199, 4399, 4599, 4799, 4999, 5199, 5399, 5599, 5799, 5999, 6199, 6399, 6599, 6799, 6999, 7199, 7399, 7599, 7799, 7999, 8199, 8399, 8599, 8799, 8999, 9199, 9399, 9599, 9799, 9999]
#slow case
time_td_ea = [1, 11, 20, 42, 97, 115, 176, 260, 372, 506, 676, 872, 1103, 1376, 1687, 2044, 2449, 2905, 3409, 3976, 4600, 5328, 6329, 6897, 7855]
counter_td_ea = [9901, 39801, 89701, 159601, 249501, 359401, 489301, 639201, 809101, 999001, 1208901, 1438801, 1688701, 1958601, 2248501, 2558401, 2888301, 3238201, 3608101, 3998001, 4407901, 4837801, 5287701, 5757601, 6247501]

# strings starting (sa) and ending (ea) in a, top down, with wrong input, ms
# input: ba..ba resp. ab..ab
# fast case
time_td_sa_w = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 4, 1, 1, 2, 5, 2, 2, 2, 2, 5, 2, 3, 3, 3, 3, 4, 4, 4, 6, 5, 6, 5, 6, 7, 7, 7, 8, 7, 8, 8, 10, 9, 8, 9, 10, 10, 10, 11]
counter_td_sa_w = [100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900, 2000, 2100, 2200, 2300, 2400, 2500, 2600, 2700, 2800, 2900, 3000, 3100, 3200, 3300, 3400, 3500, 3600, 3700, 3800, 3900, 4000, 4100, 4200, 4300, 4400, 4500, 4600, 4700, 4800, 4900, 5000]
#slow case
time_td_ea_w = [2, 13, 18, 52, 82, 134, 193, 298, 431, 572, 773, 970, 1188, 1552, 1844, 2196, 2621, 3085, 3625, 4597, 4995, 5608, 6427, 7274, 8241]
counter_td_ea_w = [9901, 39801, 89701, 159601, 249501, 359401, 489301, 639201, 809101, 999001, 1208901, 1438801, 1688701, 1958601, 2248501, 2558401, 2888301, 3238201, 3608101, 3998001, 4407901, 4837801, 5287701, 5757601, 6247501]

#input:aa..bb (length: starting 10000, ending 2500)
time_td_sa_ser = [199, 399, 599, 799, 999, 1199, 1399, 1599, 1799, 1999, 2199, 2399, 2599, 2799, 2999, 3199, 3399, 3599, 3799, 3999, 4199, 4399, 4599, 4799, 4999, 5199, 5399, 5599, 5799, 5999, 6199, 6399, 6599, 6799, 6999, 7199, 7399, 7599, 7799, 7999, 8199, 8399, 8599, 8799, 8999, 9199, 9399, 9599, 9799, 9999]
counter_td_sa_ser = [0, 0, 1, 1, 1, 1, 2, 3, 3, 4, 3, 4, 4, 7, 12, 9, 8, 8, 10, 13, 11, 10, 14, 15, 18, 15, 22, 19, 29, 19, 20, 23, 30, 28, 26, 27, 34, 31, 31, 38, 38, 37, 37, 43, 45, 47, 47, 53, 62, 54]
time_td_se_ser_w = [2, 8, 19, 41, 69, 114, 183, 250, 357, 485, 644, 835, 1061, 1322, 1626, 1967, 2359, 2802, 3283, 3841, 4440, 5105, 5834, 6624, 7479]
counter_td_se_ser_w = [9901, 39801, 89701, 159601, 249501, 359401, 489301, 639201, 809101, 999001, 1208901, 1438801, 1688701, 1958601, 2248501, 2558401, 2888301, 3238201, 3608101, 3998001, 4407901, 4837801, 5287701, 5757601, 6247501]
#TODO: this counter is exactly the same as counter counter_bu_ea_w. Compare other counters too
#input: bb..aa (length: starting 10000, ending 2500)
time_td_sa_ser_w = [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 2, 3, 1, 1, 3, 3, 2, 2, 2, 2, 2, 4, 3, 3, 4, 4, 5, 5, 6, 5, 6, 6, 8, 8, 6, 8, 7, 8, 8, 8, 9, 10, 9, 9, 11, 10, 12, 11]
counter_td_sa_ser_w = [100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900, 2000, 2100, 2200, 2300, 2400, 2500, 2600, 2700, 2800, 2900, 3000, 3100, 3200, 3300, 3400, 3500, 3600, 3700, 3800, 3900, 4000, 4100, 4200, 4300, 4400, 4500, 4600, 4700, 4800, 4900, 5000]
time_td_se_ser =
counter_td_se_ser =


"""
## dyck bottom up
plt.figure()
plt.grid(axis='y')
plt.title('Dyck language (bottom-up)')
plt.xlabel('length')
plt.ylabel('time')
plt.plot(length, time_bu_1, color='r',linestyle='-',label='bu ((..))')
plt.plot(length, time_bu_2, color='b',linestyle='-',label='bu ()..()')
plt.plot(length, time_bu_3, color='g',linestyle='-',label='bu )()..()')
plt.plot(length, time_bu_4, color='y',linestyle='-',label='bu ()..()(')
plt.legend(loc='upper left')
plt.savefig('t_dyck_bu.jpg')

plt.figure()
plt.grid(axis='y')
plt.title('Dyck language (bottom-up)')
plt.xlabel('length')
plt.ylabel('counter')
plt.plot(length, counter_bu_1, color='r',linestyle='-',label='bu ((..))')
plt.plot(length, counter_bu_2, color='b',linestyle='--',label='bu ()..()')
plt.plot(length, counter_bu_3, color='g',linestyle='-',label='bu )()..()')
plt.plot(length, counter_bu_4, color='y',linestyle='--',label='bu ()..()(')
plt.legend(loc='upper left')
plt.savefig('c_dyck_bu.jpg')





## Dyck top down slow cases
plt.figure()
plt.grid(axis='y')
plt.title('Dyck language (top-down, slow cases)')
plt.xlabel('length')
plt.ylabel('time')
plt.plot(length_2, time_td_1, color='r',linestyle='-',label='td ((..))')
plt.plot(length_2, time_td_4, color='b',linestyle='-',label='td ()..()(')
plt.legend(loc='upper left')
plt.savefig('t_dyck_td_slow.jpg')

plt.figure()
plt.grid(axis='y')
plt.title('Dyck language (top-down, slow cases)')
plt.xlabel('length')
plt.ylabel('counter')
plt.plot(length_2, counter_td_1, color='r',linestyle='-',label='td ((..))')
plt.plot(length_2, counter_td_4, color='b',linestyle='--',label='td ()..()(')
plt.legend(loc='upper left')
plt.savefig('c_dyck_td_slow.jpg')





## plots Dyck fast topdown
plt.figure()
plt.grid(axis='y')
plt.title('Dyck language (top-down, fast cases)')
plt.xlabel('length')
plt.ylabel('time')
plt.plot(length_3, time_td_2, color='r',linestyle='-',label='td ()..()')
plt.plot(length_3, time_td_3, color='b',linestyle='-',label='td )()..()')
plt.legend(loc='upper left')
plt.savefig('t_dyck_td_fast.jpg')

plt.figure()
plt.grid(axis='y')
plt.title('Dyck language (top-down, fast cases)')
plt.xlabel('length')
plt.ylabel('counter')
plt.plot(length_3, counter_td_2, color='r',linestyle='-',label='td ()..()')
plt.plot(length_3, counter_td_3, color='b',linestyle='--',label='td )()..()')
plt.legend(loc='upper left')
plt.savefig('c_dyck_td_fast.jpg')

## plots Dyck fast topdown made slow
plt.figure()
plt.grid(axis='y')
plt.title('Dyck language (different order of rules)')
plt.xlabel('length')
plt.ylabel('time')
plt.plot(length_2, time_td_5, color='r',linestyle='-',label='td ()..()')
plt.plot(length_2, time_bu_5, color='b',linestyle='-',label='bu ()..()')
plt.legend(loc='upper left')
plt.savefig('t_dyck_order.jpg')





## plots stupid grammar
plt.figure()
plt.grid(axis='y')
plt.title('\"Stupid\" grammar')
plt.xlabel('length')
plt.ylabel('time')
plt.plot(length_2, time_bu_sg, color='r',linestyle='-',label='bottom-up')
plt.plot(length_2, time_td_sg, color='b',linestyle='-',label='top-down')
plt.legend(loc='upper left')
plt.savefig('t_stupid.jpg')

plt.figure()
plt.grid(axis='y')
plt.title('\"Stupid\" grammar')
plt.xlabel('length')
plt.ylabel('counter')
plt.plot(length_2, counter_bu_sg, color='r',linestyle='-',label='bottom-up')
plt.plot(length_2, counter_td_sg, color='b',linestyle='--',label='top-down')
plt.legend(loc='upper left')
plt.savefig('c_stupid.jpg')



## plots grammar starting and ending in a
plt.figure()
plt.grid(axis='y')
plt.title('Strings starting in a, bottom-up')
plt.xlabel('length')
plt.ylabel('time')
plt.plot(length_2, time_bu_sa, color='r',linestyle='-',label='ab..ab')
plt.plot(length_2, time_bu_sa_w, color='b',linestyle='-',label='ba..ba')
plt.legend(loc='upper left')
plt.savefig('t_sa_bu.jpg')

plt.figure()
plt.grid(axis='y')
plt.title('Strings starting in a, top-down')
plt.xlabel('length')
plt.ylabel('time')
plt.plot(length, time_td_sa, color='r',linestyle='-',label='ab..ab')
plt.plot(length, time_td_sa_w, color='b',linestyle='-',label='ba..ba')
plt.legend(loc='upper left')
plt.savefig('t_sa_td.jpg')
 """


plt.figure()
plt.grid(axis='y')
plt.title('Strings ending in a')
plt.xlabel('length')
plt.ylabel('time')
plt.plot(length_2, time_bu_ea, color='r',linestyle='-',label='bottom up, ba..ba')
plt.plot(length_2, time_td_ea, color='b',linestyle='-',label='top-down, ba..ba')
plt.plot(length_2, time_bu_ea_w, color='g',linestyle='-',label='bottom-up, ab..ab')
plt.plot(length_2, time_td_ea_w, color='y',linestyle='-',label='top-down, ab..ab')
plt.legend(loc='upper left')
plt.savefig('t_ea_td_bu.jpg')

plt.figure()
plt.grid(axis='y')
plt.title('Strings starting in a, top-down')
plt.xlabel('length')
plt.ylabel('counter')
plt.plot(length, counter_td_sa, color='r',linestyle='-',label='ab..ab')
plt.plot(length, counter_td_sa_w, color='b',linestyle='-',label='ba..ba')
plt.legend(loc='upper left')
plt.savefig('c_sa_td.jpg')

## TODO: test the fast top down with different order of rules, try to make it slower.
## run tests on the grammar fr strings starting or ending in a.
## maybe also try to make a grammar for strings starting AND ending in a.
## maybe also run tests on the grammar that was used as an example. anything interesting here?