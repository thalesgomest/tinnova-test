import api from "@/api";

export async function deleteId(id: number) {
  await api.delete(`/veiculos/${id}`);
}

export default deleteId;
