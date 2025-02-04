import {ApiProperty} from "@nestjs/swagger";

export class Encrypt {
    @ApiProperty({
        description: 'Payload',
        example: '{ \"username\": \"raul.bolivar\", \"password\": \"support\" }',
        type: 'string',
    })
    data: string;
}