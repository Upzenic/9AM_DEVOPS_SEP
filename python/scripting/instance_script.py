#!/usr/bin/python 

# Script for create the EC2 intance 


import boto3


def launch_ec2():
  # Accept user inputs
  ami_id = input("Enter AMI ID (e.g., ami-0c55b159cbfafe1f0): ")
  instance_type = input("Enter Instance Type (e.g., t2.micro): ")
  count = int(input("Enter number of instances to launch: "))

  # Initialize the EC2 client
  ec2 = boto3.client("ec2")

  try:
    # Launch the instances
    response = ec2.run_instances(
        ImageId=ami_id,
        InstanceType=instance_type,
        MinCount=count,
        MaxCount=count,
    )

    print("\nSuccessfully launched instance(s):")
    for instance in response["Instances"]:
      print(" - Instance ID:", instance["InstanceId"])

  except Exception as e:
    print("\nError launching instance:", e)


# Directly call the function without the if __name__ guard
launch_ec2()


