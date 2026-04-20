//  MODO ATUAL (chuva ou agrícola)
let modoAtual = "chuva";

//  Trocar modo
function trocarModo(modo) {
  modoAtual = modo;
  document.getElementById("card").innerHTML =
    "Modo alterado para: " + modo;
}

//Hora e data da parte de cima:
function mostrarAba(aba) {
  alert("Abrir aba: " + aba);
}

function atualizarDataHora() {
  const agora = new Date();
  document.getElementById("dataHora").innerText =
    agora.toLocaleString();
}

setInterval(atualizarDataHora, 1000);

//Mapa

//  CRIAR MAPA
var map = L.map('map').setView([-22.5, -43.2], 10);

//  CARREGAR MAPA
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
  maxZoom: 19,
}).addTo(map);


//  DEFINIR NÍVEL AUTOMATICAMENTE
function definirNivel(valor) {
  if (valor <= 60) return "baixo";
  else if (valor <= 80) return "moderado";
  else return "alto";
}


// ATUALIZAR CARD
function atualizarCard(dados) {
  const card = document.getElementById("card");

  const nivel = definirNivel(dados.umidade);

  if (modoAtual === "chuva") {
    card.innerHTML = `
      <b>📍 ${dados.local}</b><br>
      Saturação: ${dados.umidade}%<br>
      Nível: ${nivel === "alto" ? " Alto" : nivel === "moderado" ? " Moderado" : " Baixo"}<br>
      Última atualização: ${dados.hora}
    `;
  }

}


//  DADOS SIMULADOS DOS SENSORES
const sensores = [
  {
    local: "Petrópolis",
    coords: [-22.5, -43.2],
    umidade: 92,
    ph: 5.5,
    recomendacao: "Aplicar corretivo",
    hora: "10:30"
  },
  {
    local: "Rio de Janeiro",
    coords: [-22.9, -43.2],
    umidade: 65,
    ph: 6.2,
    recomendacao: "Solo equilibrado",
    hora: "10:32"
  },
  {
    local: "Teresópolis",
    coords: [-22.4, -42.9],
    umidade: 40,
    ph: 6.8,
    recomendacao: "Irrigar",
    hora: "10:35"
  }
];


//  CRIAR MARCADORES
sensores.forEach(sensor => {
  const marcador = L.marker(sensor.coords).addTo(map);

  marcador.on('click', function () {
    atualizarCard(sensor);
  });
});