import { Module } from '@nestjs/common';
import { SymmetricModule } from './symmetric/symmetric.module';

@Module({
  imports: [SymmetricModule],
})
export class AppModule {}
