#! bin/bash
echo "Server Details"
echo "Name: $(hostname)"
echo "Memory:"
free -h
echo "CPU:"
top | head -5
echo "Disk"
df -h
