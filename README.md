WeatherApp - Atividade 02 de PDM

Um aplicativo Android simples que busca e exibe informações de clima, desenvolvido como um projeto para a disciplina de Programação para Dispositivos Moveis.

O projeto foi criado com fins educacionais para demonstrar o consumo de APIs REST, manipulação de dados JSON e a construção de uma interface de usuário dinâmica com componentes modernos do Android.

---

🚀 Funcionalidades

* **Clima Atual:** Exibe a temperatura atual, condição do tempo (ensolarado, nublado, etc.), umidade, velocidade do vento e sensação térmica.
* **Busca por Cidade:** Permite que o usuário digite o nome de uma cidade para obter os dados climáticos correspondentes.
* **Previsão do Tempo:** Mostra uma previsão do momento
* **Interface Dinâmica:** Ícones e/ou cores de fundo que se alteram de acordo com a condição do tempo (dia/noite, chuva, etc.).

---

💻 Tecnologias e Conceitos Utilizados

* **Linguagem:** Kotlin (ou Java)
* **IDE:** Android Studio
* **Framework:** Android SDK
* **Bibliotecas Principais:**
    * **Retrofit:** Para fazer as chamadas HTTP à API de clima de forma eficiente.
    * **GSON / Moshi:** Para converter a resposta da API (JSON) em objetos Kotlin/Java.
* **Componentes de UI:**
    * `RecyclerView`: Para exibir a lista de previsão do tempo.
    * `EditText` / `SearchView`: Para a funcionalidade de busca de cidade.
    * `ImageView`: Para exibir os ícones do clima.
    * `TextView`: Para exibir todas as informações de texto.
    * `ProgressBar`: Para indicar o carregamento dos dados.

---

### 📱 Demonstração do Fluxo

1.  Ao abrir o app, ele mostrara a tela inicial.
2.  O usuário pode usar a barra de busca para pesquisar o nome de uma cidade.
4.  A aplicação faz uma nova chamada à API com a cidade pesquisada.
5.  A tela é atualizada com os novos dados de clima atual.
6.  Ao clicar sobre o resultado da pesquisa, uma nova tela abrirá aonde mais informações aparecerão ao usuário.

---

### 📡 API Utilizada

Este projeto utiliza a API gratuita **OpenWeatherMap** para obter os dados de clima. É necessário um cadastro para obter uma chave de acesso (API Key) para que as chamadas funcionem.

---

### 🎯 Objetivos de Aprendizagem

* Entender o ciclo de uma requisição de rede em um app Android.
* Aprender a consumir uma dados de uma API com a biblioteca Retrofit.
* Realizar o *parsing* de dados no formato JSON.
* Implementar uma lista dinâmica e eficiente usando `RecyclerView`.
* Aplicar princípios de arquitetura limpa (como MVVM) para separar responsabilidades no código.

---

### 📝 Licença

Este projeto foi desenvolvido para fins didáticos e pode ser usado livremente como material de estudo e portfólio acadêmico.
