export interface Vehicle {
  id?: number;
  createdAt?: Date;
  updatedAt?: Date;
  nome: string;
  marca: string;
  ano: number;
  cor: string;
  descricao: string;
  vendido: boolean;
}
