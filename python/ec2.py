
import boto3
# 1. Collect AWS Credentials and configurationprint("--- AWS Authentication ---")
access_key = input("Enter AWS Access Key ID: ").strip()
secret_key = input("Enter AWS Secret Access Key: ").strip()
region_name = input("Enter AWS Region: ").strip()
# 2. Collect Instance detailsprint("\n--- EC2 Configuration ---")
ami_id = input("Enter the AMI ID: ").strip()
instance_type = input("Enter the Instance Type: ").strip()
instance_count = int(input("Enter the number of instances to launch: "))
# 3. Create session and client
session = boto3.Session(
    aws_access_key_id=access_key,
    aws_secret_access_key=secret_key,
    region_name=region_name
)

ec2_client = session.client('ec2')

print(f"\nLaunching {instance_count} instance(s)...")
# 4. Launch the instances
response = ec2_client.run_instances(
    ImageId=ami_id,
    InstanceType=instance_type,
    MinCount=instance_count,
    MaxCount=instance_count
)
# 5. Output results
print("\nSuccessfully triggered instance creation!")
for instance in response['Instances']:
    print(f" - Instance ID: {instance['InstanceId']} | State: {instance['State']['Name']}")
