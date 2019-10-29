from matplotlib import pyplot as PLT
import numpy as NP
import math

with open('out.csv') as f:
    v = NP.loadtxt(f, delimiter=",", dtype='double', comments="#", skiprows=1, usecols=None)

v_hist = NP.ravel(v)  # 'flatten' v
fig = PLT.figure()
ax1 = fig.add_subplot(111)

n, bins, patches = ax1.hist(v_hist, bins=50, normed=1, color='lightblue', histtype='stepfilled')
ax1.plot(NP.arange(-4, 4, 0.1),
         [(1 / math.sqrt(2 * math.pi)) * math.exp(-1 * y ** 2 / 2) for y in NP.arange(-4, 4, 0.1)])

PLT.show()
