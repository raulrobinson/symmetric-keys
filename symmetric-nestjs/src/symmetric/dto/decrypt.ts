import {ApiProperty} from "@nestjs/swagger";

export class Decrypt {
    @ApiProperty({
        description: 'Payload',
        example: 'AkkeHYbUpR7LPQSC6Di2x3E77N437O97D5W+HJDVMxFuOKppQ1SN7Df8uFkNJW20XXjkzOsPFsIgp7eQ8mgquLWHUpjeYb9EmvExqht4ighGmUpjbHm0O/qNNZ5iwYb9Vnm+zr4Im8+wmsOhS3NRpRhLdzvB6iKK0vfabWY2qmjjD6qRLTF4wCZWh009wv6N0LqH40GFScTqOtAcmckqtoJBeZyjVIeVP8zPf7g8FUqIp9TynRGQ1uhnAGK8GX9bMKVHQiox0xQgJUIraUhCSWxS2PGmLnfpWdJ/1Er4VYaq5EgFxHKWFHB//jyntelPUpEAXLDy7oLNx6JFVESXIg==',
        type: 'string',
    })
    data: string;
}