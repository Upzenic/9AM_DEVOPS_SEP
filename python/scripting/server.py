#!/usr/bin/python

# linux server details

import platform
import os

print("Hostname    :", platform.node())
print("OS / Kernel :", platform.system(), platform.release())
print("Architecture:", platform.machine())
print("CPU Cores   :", os.cpu_count())


