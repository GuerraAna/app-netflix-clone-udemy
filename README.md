# app-netflix-clone-udemy

Clone da **interface e fluxo de login do Netflix** — exercício do curso Android da Udemy.

## Objetivo

Reproduzir telas reais do Netflix: autenticação (login/cadastro via Firebase Auth) e catálogo com imagens.

## Tecnologias

- Kotlin
- **Firebase Auth** (`google-services.json` já incluído)
- **Picasso** (capas dos filmes)
- AppCompat, Material, ConstraintLayout
- AGP 4.2.1 / Gradle 6.7.1

## Pré-requisitos

- **JDK 11**
- Android SDK

## Como rodar

```bash
echo "sdk.dir=$HOME/Library/Android/sdk" > local.properties   # macOS
./gradlew assembleDebug
```

O login usa o projeto Firebase original (`google-services.json` commitado) — autenticação por e-mail/senha.
