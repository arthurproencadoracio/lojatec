# Estágio 1: Instalação de dependências e build
FROM python:3.11-slim AS builder
WORKDIR /app

RUN apt-get update && apt-get install -y --no-install-recommends gcc python3-dev

COPY requirements.txt .
RUN pip install --no-cache-dir --user -r requirements.txt

# Estágio 2: Imagem final leve de execução
FROM python:3.11-slim
WORKDIR /app

# Cria usuário não-root por motivos de conformidade de segurança corporativa
RUN addgroup --system teclojagroup && adduser --system --group teclojauser
USER teclojauser

# Copia os pacotes instalados do estágio builder
COPY --from=builder /root/.local /home/teclojauser/.local
COPY . .

ENV PATH=/home/teclojauser/.local/bin:$PATH
ENV PORT=8000

EXPOSE 8000

CMD ["sh", "-c", "uvicorn app.main:app --host 0.0.0.0 --port ${PORT}"]
