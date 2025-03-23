import api from "@/api";

async function getAll(marca?: string, ano?: number, cor?: string) {
  // const url = new URL("/veiculos", api.defaults.baseURL);
  const params: Record<string, string | number> = {};

  if (marca) params.marca = marca;
  if (ano) params.ano = ano;
  if (cor) params.cor = cor;
  const response = await api.get("/veiculos", { params });

  return response.data;
}

export default getAll;
