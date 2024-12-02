
import os
import argparse

parser = argparse.ArgumentParser(usage="Config File Generator")
parser.add_argument("-rc", "-recordcount", type=int,default=1000)
parser.add_argument("-oc", "-operationcount", type=int,default=1000)
parser.add_argument("-rp", "-readproportion", type=float, help="A floating-point number",default=0.5)
parser.add_argument("-up", "-updateproportion", type=float, help="A floating-point number",default=0.5)
parser.add_argument("-sp", "-scanproportion", type=float, help="A floating-point number",default=0.0)
parser.add_argument("-ip", "-insertproportion", type=float, help="A floating-point number",default=0.0)
parser.add_argument("-rd", "-requestdistribution", type=str,default="zipfian")

args = parser.parse_args()
#lets store those in a value because the user can input either or



#create the files
#initialize the file in a value first
file = input("Enter file location to save the config: ")
with open(file, 'w') as file:
    file.write("#This is a user generated config file\n")
    file.write("#Default data size: 1 KB records (10 fields, 100 bytes each, plus key\n")
    file.write(f"recordcount={args.rc}\n")
    file.write(f"operationcount={args.oc}\n")
    file.write(f"workload=site.ycsb.workloads.CoreWorkload\n")
    file.write("\n")
    file.write(f"readallfields=true\n")
    file.write("\n")
    file.write(f"readproportion={args.rp}\n")
    file.write(f"updateproportion={args.up}\n")
    file.write(f"scanproportion={args.sp}\n")
    file.write(f"insertproportion={args.ip}\n")
    file.write("\n")
    file.write(f"requestdistribution={args.rd}\n")
    