import boto3
import json
import os

print('Loading function')

#create the client outside of the handler
region_name = os.environ['REGION_NAME']
dynamo = boto3.client('dynamodb', region_name=region_name)
table_name = os.environ['TABLE_NAME']


def lambda_handler(event, context):
        print("Received Event: " + json.dumps(event, ident=2))
        scan_result = dynamo.scan(TableName=table_name)