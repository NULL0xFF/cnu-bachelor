for firstNum in range (1, 13, 1):
    print("%s %d 단 %s" % ("="*5, firstNum, "="*5))
    for lastNum in range (1, 13, 1):
        print("%d * %d = %d" % (firstNum, lastNum, firstNum * lastNum))
    print("=" * 16)
