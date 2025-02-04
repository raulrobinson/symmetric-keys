import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';
import {DocumentBuilder, SwaggerModule} from "@nestjs/swagger";

async function bootstrap() {
  const app = await NestFactory.create(AppModule);

  const options = new DocumentBuilder()
      .setTitle('Symmetric Nestjs')
      .setDescription('The symmetric nestjs API description')
      .setVersion('1.0.0')
      .addTag('Encrypt-Decrypt')
      .setContact(
          'Raul R. Bolivar Navas',
          'https://www.linkedin.com/in/rasysbox',
          'rasysbox@hotmail.com',
      )
      .build();
  const document = SwaggerModule.createDocument(app, options);
  SwaggerModule.setup('api-docs', app, document);

  await app.listen(3000, () => {
    console.log('Application is running on: http://localhost:3000');
  });
}
bootstrap();
