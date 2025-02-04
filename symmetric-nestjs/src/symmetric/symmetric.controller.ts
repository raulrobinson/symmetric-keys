import {ApiBody, ApiConsumes, ApiOperation, ApiResponse, ApiTags} from "@nestjs/swagger";
import {Body, Controller, Post} from '@nestjs/common';
import {SymmetricService} from "./symmetric.service";
import {Encrypt} from "./dto/encrypt";
import {Decrypt} from "./dto/decrypt";
import {Response} from "./dto/response";

@Controller('symmetric')
@ApiTags('Symmetric')
export class SymmetricController {
    constructor(
        private readonly symmetricService: SymmetricService,
    ) {}

    @Post('encrypt-jwe')
    @ApiConsumes('application/x-www-form-urlencoded')
    @ApiBody({ type: Encrypt })
    @ApiOperation({ summary: 'Encrypt data format JSON' })
    async encryptJWE(@Body() payload: Encrypt): Promise<Response> {
        return await this.symmetricService.encrypt(payload.data);
    }

    @Post('decrypt-jwe')
    @ApiConsumes('application/x-www-form-urlencoded')
    @ApiBody({ type: Decrypt })
    @ApiOperation({ summary: 'Decrypt data using JWE' })
    async decryptJWE(@Body() payload: Decrypt): Promise<any> {
        return await this.symmetricService.decrypt(payload.data);
    }
}
