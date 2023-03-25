alpha='ABCDEFGHIJKLMNOPQRSTUVWXYZ'
def c_sub(string):
    while True:
        print(string)
        print('')
        print([i+':'+str(string.count(i)) for i in alpha])
        print('')
        print("Remember, the most common letters in the English alphabet are: 'ETAOINSHRDLU'")
        print('')
        userInput=input("Type a pair of letters to swap, for example AB would swap A and B, or type 'quit':")
        if userInput=='quit': return
        string=string.replace(userInput[0],'plzdontusethisexactphrase')
        string=string.replace(userInput[1],userInput[0])
        string=string.replace('plzdontusethisexactphrase',userInput[1])

#c_sub("XMTP CGPQR BWEKNJB GQ OTGRB EL BEQX BWEKNJB, G RFGLI. GR GQ BEQX ABSETQB RFGQ QBLRBLSB TQBQ EJJ RBL KMQR SMKKML VMPYQ GL BLDJGQF: 'G FEUB RM AB E DMMY QRTYBLR GL RFER SJEQQ GL RFB PMMK MC RFER RBESFBP.'")
#YOUR FIRST EXAMPLE IS QUITE AN EASY EXAMPLE, I THINK. IT IS EASY BECAUSE THIS SENTENCE USES ALL TEN MOST COMMON WORDS IN ENGLISH: 'I HAVE TO BE A GOOD STUDENT IN THAT CLASS IN THE ROOM OF THAT TEACHER.'
#c_sub("XTV B CHDQCL BHF GCVIVDGDHWPN ABVF ZABPPLHWL, ZTHGDFLV MBJDHW B PTHW BHF XCPPN VLBFBYPL GLVDLG TX UTVFG HLRLV CGDHW B GDHWPL LEBMIPL TX TCV ULPPPTRLF LHWPDGA WPNIA UADZA TZZCVG GLZTHF IPBZL DH TRLVBPP XVLQCLHZN. DX D BM WLHCDHL, D UDPP GBN MBHN, MBHN GLZTHFG ABRL IBGGLF UADPL D ABRL YLLH ALVL ITHFLVDHW MBJDHW GCZA B UTVJ. FDGZTRLVDHW NTC ZVBZJLF MN YVBDHZADPF, ALVL, DH B GMBPPLV HCMYLV TX GLZTHFG UTCPF WDRL ML HT GCVIVDGL.")
#FOR A UNIQUE AND SURPRISINGLY HARD CHALLENGE, CONSIDER MAKING A LONG AND FULLY READABLE SERIES OF WORDS NEVER USING A SINGLE EXAMPLE OF OUR WELLLOVED ENGLISH GLYPH WHICH OCCURS SECOND PLACE IN OVERALL FREQUENCY. IF I AM GENUINE, I WILL SAY MANY, MANY SECONDS HAVE PASSED WHILE I HAVE BEEN HERE PONDERING MAKING SUCH A WORK. DISCOVERING YOU CRACKED MY BRAINCHILD, HERE, IN A SMALLER NUMBER OF SECONDS WOULD GIVE ME NO SURPRISE.
#c_sub("LTQCXT LRJJ HJRDECD, EZT CDJP SXTFRYTDE EC ZNKT LTTD RASTNHZTY VNF NDYXTV WCZDFCD. ZT VNF NHUBREETY LP N FRDGJT KCET VZTD N LXNKT FTDNECX QXCA ONDFNF XTQBFTY EC PRTJY QXCA SXTFFBXT EC HCDKRHE EZT SXTFRYTDE. ZNY WCZDFCD LTTD HCDKRHETY, EZT FSTNOTX CQ EZT ZCBFT VCBJY ZNKT LTHCAT SXTFRYTDE FRDHT WCZDFCD ZNY DC KRHTSXTFRYTDE. RDHXTYRLJP, RE VNF EZRF FNAT FSTNOTX VZC JTY EZT RASTNHZATDE RD EZT ZCBFT CQ XTSXTFTDENERKTF. EZBF, ZNY EZT FTDNET HCDKRHETY EZT SXTFRYTDE, EZRF VCBJY ZNKT NACBDETY EC N SCJRERHNJ HCBS.")
#BEFORE BILL CLINTON, THE ONLY PRESIDENT TO HAVE BEEN IMPEACHED WAS ANDREW JOHNSON. HE WAS ACQUITTED BY A SINGLE VOTE WHEN A BRAVE SENATOR FROM KANSAS REFUSED TO YIELD FROM PRESSURE TO CONVICT THE PRESIDENT. HAD JOHNSON BEEN CONVICTED, THE SPEAKER OF THE HOUSE WOULD HAVE BECOME PRESIDENT SINCE JOHNSON HAD NO VICEPRESIDENT. INCREDIBLY, IT WAS THIS SAME SPEAKER WHO LED THE IMPEACHMENT IN THE HOUSE OF REPRESENTATIVES. THUS, HAD THE SENATE CONVICTED THE PRESIDENT, THIS WOULD HAVE AMOUNTED TO A POLITICAL COUP.
#c_sub("NU XTZEIMYTNEVZ INUHU YM, ZML SPYVI NXILNFFZ XNFF IVPU N API VNTD. NU PI ILTWU MLI, P XNW YM N FMWY JNZ JPIVMLI LUPWY NWZ MC IVNI YFZEV IVNI ITNDPIPMWNFFZ CMFFMJU 'D' NI NFF. PUW'I IVNI ULTETPUPWY? P CMLWD IVPU ULTETPUPWY, NWZJNZ! NW NLIVMT JVM NFUM CMLWD IVPU ULTETPUPWY, FMWY NYM, NXILNFFZ FMUI SNWZ SMWIVU JTPIPWY N AMMH - N CLFF CPXIPMWNF UIMTZ - JPIVMLI IVNI YFZEV NI NFF. NSNRPWY, TPYVI?")
#AS CRYPTOGRAPHY TASKS GO, YOU MIGHT ACTUALLY CALL THIS A BIT HARD. AS IT TURNS OUT, I CAN GO A LONG WAY WITHOUT USING ANY OF THAT GLYPH THAT TRADITIONALLY FOLLOWS 'D' AT ALL. ISN'T THAT SURPRISING? I FOUND THIS SURPRISING, ANYWAY! AN AUTHOR WHO ALSO FOUND THIS SURPRISING, LONG AGO, ACTUALLY LOST MANY MONTHS WRITING A BOOK - A FULL FICTIONAL STORY - WITHOUT THAT GLYPH AT ALL. AMAZING, RIGHT?
       