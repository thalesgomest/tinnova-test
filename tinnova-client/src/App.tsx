import TinnovaLogo from "@/assets/images/tinnova-logo.svg";
import { PlusCircle, Search, TrashIcon } from "lucide-react";
import { Button } from "./components/ui/button";
import { Input } from "./components/ui/input";
import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "./components/ui/table";

function App() {
  const brands = [
    "Honda",
    "Ford",
    "Volkswagen",
    "Chevrolet",
    "Nissan",
    "Toyota",
    "Hyundai",
  ];

  return (
    <>
      <div className="w-xs mx-auto my-4">
        <img src={TinnovaLogo} alt="Tinnova Logo" />
      </div>
      <div className="p-4 max-w-4xl mx-auto space-y-4">
        <div className="w-xs my-4">
          <h1 className="text-left text-xl text-neutral-300 font-bold p-2 rounded-lg">
            Tabela de Cadastro de Produtos
          </h1>
        </div>
        <div className="flex items-center justify-between">
          <form className="flex items-center gap-2">
            <Input name="id" placeholder="ID do Produto"></Input>
            <Input name="name" placeholder="Nome do Produto"></Input>
            <Button type="submit" className="bg-pink-500">
              <Search className="w-4 h-4 mr-2" />
              Filtra resultados
            </Button>
          </form>
          <Button className="bg-pink-500">
            <PlusCircle className="w-4 h-4 mr-2" /> Novo Produto
          </Button>
        </div>
        <div className="border rounded-lg p-2">
          <Table>
            <TableHeader>
              <TableHead>ID</TableHead>
              <TableHead>Veículo</TableHead>
              <TableHead>Marca</TableHead>
              <TableHead>Ano</TableHead>
              <TableHead>Descrição</TableHead>
              <TableHead>Vendido</TableHead>
            </TableHeader>
            <TableBody>
              {Array.from({ length: 10 }).map((_, index) => (
                <TableRow key={index}>
                  <TableCell>81es12134rdad</TableCell>
                  <TableCell>Veículo {index + 1}</TableCell>
                  <TableCell>
                    {brands[Math.floor(Math.random() * brands.length)]}
                  </TableCell>
                  <TableCell>2022</TableCell>
                  <TableCell>Descrição do Veículo</TableCell>
                  <TableCell>Sim</TableCell>
                  <TableCell>
                    <TrashIcon className="w-4 h-4" />
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </div>
      </div>
    </>
  );
}

export default App;

