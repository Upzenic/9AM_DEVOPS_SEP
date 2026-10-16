import boto3
# Ask for the region
region = input("Enter AWS region: ")


# Ask for the AMI ID
ami_id = input("Enter AMI ID: ")


# Ask for the instance type
instance_type = input("Enter instance type: ")


# Ask for the count
count =int(input("Enter number of instances: "))



# Create the EC2 helper
aws_helper = boto3.client(
    "ec2",
    region_name=region
)

# Launch instances and store the result
instance_created_result = aws_helper.run_instances(
    ImageId=ami_id,
    InstanceType=instance_type,
    MinCount=count,
    MaxCount=count
)

print(instance_created_result)

