import { Module } from '@nestjs/common';
import { SymmetricService } from './symmetric.service';
import { SymmetricController } from './symmetric.controller';

@Module({
  providers: [SymmetricService],
  controllers: [SymmetricController]
})
export class SymmetricModule {}
