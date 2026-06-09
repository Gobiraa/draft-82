# 🏀 Draft 82 (The Perfect Season)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![React](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)

**Draft 82** é um jogo de simulação e gerenciamento de draft no navegador. O objetivo do jogador é analisar elencos históricos da NBA sorteados aleatoriamente por décadas e montar o quinteto perfeito para tentar bater o recorde absoluto da liga: uma temporada impecável de 82 vitórias e 0 derrotas.

## 🎯 Como Funciona
1. **O Sorteio:** A cada rodada, o sistema fornece uma franquia e uma década histórica específica (ex: *Los Angeles Lakers - Anos 2010*).
2. **A Escolha:** O jogador deve analisar o elenco daquela era e escolher um atleta para preencher uma das 5 posições do quinteto titular (PG, SG, SF, PF, C).
3. **O Rigor Tático:** O sistema bloqueia escalações irreais. Um jogador só pode ser escalado nas posições em que atuou oficialmente naquela década.
4. **O Veredito:** Após as 5 escolhas, um algoritmo de Média Ponderada baseado em estatísticas reais projeta o recorde de vitórias e derrotas da sua equipe.

---

## 🏗️ Arquitetura do Sistema (UML)

O backend foi modelado focando na separação clara entre **dados dimensionais históricos** (imutáveis, importados via CSV) e os **dados transacionais** (a sessão temporária do usuário jogando). 

La validação de regras de negócio (como a verificação de posições válidas) é garantida no servidor pelo Spring Boot.

```mermaid
classDiagram
    direction TB

    class GameSession {
        - id: UUID
        - rodadaAtual: int
        - status: String
        - recordeFinal: String
        - temporadaPerfeita: boolean
        + iniciarNovoDraft(): void
        + selecionarJogador(jogador: PlayerDecade, posicao: String): boolean
        + calcularProjecaoFinal(): String
    }

    class DraftPick {
        - id: Long
        - posicaoSelecionada: String
        + validarCompatibilidade(): boolean
    }

    class TeamDecade {
        - id: Long
        - nomeFranquia: String
        - decada: String
        + obterElenco(): List~PlayerDecade~
    }

    class PlayerDecade {
        - id: Long
        - nome: String
        - posicoesValidas: String
        - pontos: double
        - assistencias: double
        - rebotes: double
        - roubos: double
        - tocos: double
        - turnovers: double
        - overallBase: double
        + verificarPosicaoValida(posicao: String): boolean
    }

    GameSession "1" *-- "5" DraftPick : contem
    DraftPick "0..1" o-- "1" PlayerDecade : seleciona
    TeamDecade "1" *-- "N" PlayerDecade : possui
```

---

## 🗄️ Modelagem da Base de Dados (ER)

O esquema relacional divide-se em duas partes: tabelas estáticas de consulta (`TEAM_DECADE` e `PLAYER_DECADE`) e tabelas dinâmicas de estado do jogo (`GAME_SESSION` e `DRAFT_PICK`).

```mermaid
erDiagram
    TEAM_DECADE {
        BIGINT id PK
        VARCHAR nome_franquia "ex: Los Angeles Lakers"
        VARCHAR decada "ex: 2010s"
    }

    PLAYER_DECADE {
        BIGINT id PK
        BIGINT team_decade_id FK
        VARCHAR nome
        VARCHAR posicoes_validas "ex: SF,PF,PG"
        DECIMAL pontos
        DECIMAL assistencias
        DECIMAL rebotes
        DECIMAL roubos
        DECIMAL tocos
        DECIMAL turnovers
        INT overall_calculado
    }

    GAME_SESSION {
        UUID id PK
        INT rodada_atual "1 a 5"
        VARCHAR status "EM_ANDAMENTO, FINALIZADO"
        INT vitorias_projetadas "ex: 82"
        INT derrotas_projetadas "ex: 0"
    }

    DRAFT_PICK {
        BIGINT id PK
        UUID session_id FK
        BIGINT player_decade_id FK
        VARCHAR posicao_slot "PG, SG, SF, PF, C"
    }

    TEAM_DECADE ||--o{ PLAYER_DECADE : possui
    GAME_SESSION ||--|{ DRAFT_PICK : contem
    PLAYER_DECADE ||--o{ DRAFT_PICK : selecionado_em
```

---
