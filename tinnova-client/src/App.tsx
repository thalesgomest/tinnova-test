import TinnovaLogo from "@/assets/images/tinnova-logo.svg";
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";
import { PlusCircle, Search, TrashIcon } from "lucide-react";
import { useEffect, useState } from "react";
import { ToastContainer, toast } from "react-toastify";
import { Button } from "./components/ui/button";
import {
  Dialog,
  DialogClose,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "./components/ui/dialog";
import { Input } from "./components/ui/input";
import { Label } from "./components/ui/label";
import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "./components/ui/table";
import { Vehicle } from "./domain/vehicle";
import deleteId from "./services/delete-Id";
import getAll from "./services/get-All";
import { postVehicle } from "./services/post";

function App() {
  const [vehicles, setVehicles] = useState<Vehicle[]>([]);
  const [vehicleBrand, setVehicleBrand] = useState("");
  const [vehicleColor, setVehicleColor] = useState("");
  const [vehicleYear, setVehicleYear] = useState("");
  const [formData, setFormData] = useState({
    nome: "",
    marca: "",
    ano: "",
    cor: "",
    descricao: "",
    vendido: "",
  });

  const handleChange = (
    e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>
  ) => {
    const { id, value } = e.target;
    setFormData((prev) => ({ ...prev, [id]: value }));
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();

    // Convertendo os valores necessários
    const postData = {
      ...formData,
      ano: Number(formData.ano), // Converte para número
      vendido: formData.vendido === "true", // Converte para boolean
    };

    await postVehicle(postData)
      .then(() => {
        handleGetAll();
        cleanerFilter();
      })
      .catch((err) => toast.error(err.message));

    setFormData({
      nome: "",
      marca: "",
      ano: "",
      cor: "",
      descricao: "",
      vendido: "",
    });
  };

  const handleGetAll = () => {
    getAll(vehicleBrand, Number(vehicleYear), vehicleColor)
      .then((res) => setVehicles(res))
      .catch((err) => toast.error(err.message));
  };

  const handleDelete = (id: number) => {
    deleteId(id)
      .then(() => handleGetAll())
      .catch((err) => toast.error(err.message));
  };

  const handleFilter = () => {
    cleanerFilter();
  };

  const cleanerFilter = () => {
    setVehicleBrand("");
    setVehicleColor("");
    setVehicleYear("");
  };

  useEffect(() => {
    handleGetAll();
  }, []);

  return (
    <>
      <div className="w-xs mx-auto my-4">
        <img src={TinnovaLogo} alt="Tinnova Logo" />
      </div>

      <div className="p-4 max-w-5xl mx-auto space-y-4">
        <div className="w-lg my-4">
          <h1 className="text-left text-3xl text-neutral-300 font-bold p-2">
            Cadastro de Veículos
          </h1>
        </div>
        <div className="flex items-center justify-between">
          <form className="flex items-center gap-2">
            <Select value={vehicleBrand} onValueChange={setVehicleBrand}>
              <SelectTrigger className="text-neutral-300">
                <SelectValue placeholder="Marca do Veiculo" />
              </SelectTrigger>
              <SelectContent>
                <SelectItem value="FORD">FORD</SelectItem>
                <SelectItem value="CHEVROLET">CHEVROLET</SelectItem>
                <SelectItem value="TOYOTA">TOYOTA</SelectItem>
                <SelectItem value="VOLKSWAGEN">VOLKSWAGEN</SelectItem>
                <SelectItem value="NISSAN">NISSAN</SelectItem>
                <SelectItem value="HONDA">HONDA</SelectItem>
                <SelectItem value="BMW">BMW</SelectItem>
                <SelectItem value="MERCEDES">MERCEDES</SelectItem>
                <SelectItem value="AUDI">AUDI</SelectItem>
                <SelectItem value="FIAT">FIAT</SelectItem>
              </SelectContent>
            </Select>

            <Input
              name="cor"
              value={vehicleColor}
              onChange={(e) => setVehicleColor(e.target.value)}
              placeholder="Cor do Veiculo"
            ></Input>
            <Input
              name="ano"
              value={vehicleYear}
              onChange={(e) => setVehicleYear(e.target.value)}
              placeholder="Ano do Produto"
              className="text-neutral-300"
            ></Input>
            <Button
              type="button"
              onClick={handleGetAll}
              className="bg-pink-500"
            >
              <Search className="w-4 h-4 mr-2" />
              Filtrar
            </Button>
            <Button
              type="button"
              onClick={handleFilter}
              className="bg-pink-500"
            >
              Limpar Filtro
            </Button>
          </form>
          <Dialog>
            <DialogTrigger asChild>
              <Button className="bg-pink-500">
                <PlusCircle className="w-4 h-4 mr-2" /> Novo Produto
              </Button>
            </DialogTrigger>
            <DialogContent>
              <DialogHeader>
                <DialogTitle className="text-neutral-300">
                  Novo Veiculo
                </DialogTitle>
                <DialogDescription>
                  Adicione um novo veiculo ao estoque
                </DialogDescription>
              </DialogHeader>

              <form className="space-y-6" onSubmit={handleSubmit}>
                <div className="grid grid-cols-4 items-center text-right gap-3">
                  <Label htmlFor="nome" className="text-neutral-300 col-span-1">
                    Nome
                  </Label>
                  <Input
                    className="col-span-3"
                    id="nome"
                    value={formData.nome}
                    onChange={handleChange}
                  />
                </div>

                <div className="grid grid-cols-4 items-center text-right gap-3">
                  <Label
                    htmlFor="marca"
                    className="text-neutral-300 col-span-1"
                  >
                    Marca
                  </Label>
                  <div id="marca" className="col-span-3">
                    <Select
                      value={formData.marca}
                      onValueChange={(value) =>
                        setFormData((prev) => ({ ...prev, marca: value }))
                      }
                    >
                      <SelectTrigger className="text-neutral-300 w-full">
                        <SelectValue placeholder="Marca do Veículo" />
                      </SelectTrigger>
                      <SelectContent>
                        <SelectItem value="FORD">FORD</SelectItem>
                        <SelectItem value="CHEVROLET">CHEVROLET</SelectItem>
                        <SelectItem value="TOYOTA">TOYOTA</SelectItem>
                        <SelectItem value="VOLKSWAGEN">VOLKSWAGEN</SelectItem>
                        <SelectItem value="NISSAN">NISSAN</SelectItem>
                        <SelectItem value="HONDA">HONDA</SelectItem>
                        <SelectItem value="BMW">BMW</SelectItem>
                        <SelectItem value="MERCEDES">MERCEDES</SelectItem>
                        <SelectItem value="AUDI">AUDI</SelectItem>
                        <SelectItem value="FIAT">FIAT</SelectItem>
                      </SelectContent>
                    </Select>
                  </div>
                </div>

                <div className="grid grid-cols-4 items-center text-right gap-3">
                  <Label htmlFor="ano" className="text-neutral-300 col-span-1">
                    Ano
                  </Label>
                  <Input
                    className="col-span-3"
                    id="ano"
                    value={formData.ano}
                    onChange={handleChange}
                  />
                </div>

                <div className="grid grid-cols-4 items-center text-right gap-3">
                  <Label htmlFor="cor" className="text-neutral-300 col-span-1">
                    Cor
                  </Label>
                  <Input
                    className="col-span-3"
                    id="cor"
                    value={formData.cor}
                    onChange={handleChange}
                  />
                </div>

                <div className="grid grid-cols-4 items-center text-right gap-3">
                  <Label
                    htmlFor="descricao"
                    className="text-neutral-300 col-span-1"
                  >
                    Descrição
                  </Label>
                  <Input
                    className="col-span-3"
                    id="descricao"
                    value={formData.descricao}
                    onChange={handleChange}
                  />
                </div>

                <div className="grid grid-cols-4 items-center text-right gap-3">
                  <Label
                    htmlFor="vendido"
                    className="text-neutral-300 col-span-1"
                  >
                    Vendido
                  </Label>
                  <div id="vendido" className="col-span-3">
                    <Select
                      value={formData.vendido}
                      onValueChange={(value) =>
                        setFormData((prev) => ({ ...prev, vendido: value }))
                      }
                    >
                      <SelectTrigger className="text-neutral-300 w-full">
                        <SelectValue placeholder="Selecionar" />
                      </SelectTrigger>
                      <SelectContent>
                        <SelectItem value="true">Sim</SelectItem>
                        <SelectItem value="false">Não</SelectItem>
                      </SelectContent>
                    </Select>
                  </div>
                </div>
              </form>
              <DialogFooter>
                <DialogClose asChild>
                  <Button
                    type="submit"
                    variant="default"
                    onClick={handleSubmit}
                  >
                    Cadastrar
                  </Button>
                </DialogClose>
                <DialogClose asChild>
                  <Button type="button" variant="destructive">
                    Fechar
                  </Button>
                </DialogClose>
              </DialogFooter>
            </DialogContent>
          </Dialog>
        </div>
        <div className="border rounded-lg p-2">
          <Table>
            <TableHeader>
              <TableHead>ID</TableHead>
              <TableHead>Veículo</TableHead>
              <TableHead>Marca</TableHead>
              <TableHead>Cor</TableHead>
              <TableHead>Ano</TableHead>
              <TableHead>Descrição</TableHead>
              <TableHead>Vendido</TableHead>
            </TableHeader>
            <TableBody>
              {vehicles.map((vehicle, index) => (
                <TableRow key={index}>
                  <TableCell>{vehicle.id}</TableCell>
                  <TableCell>{vehicle.nome}</TableCell>
                  <TableCell>{vehicle.marca}</TableCell>
                  <TableCell>{vehicle.cor}</TableCell>
                  <TableCell>{vehicle.ano}</TableCell>
                  <TableCell>{vehicle.descricao}</TableCell>
                  <TableCell>{vehicle.vendido ? "Sim" : "Não"}</TableCell>
                  <TableCell>
                    <Dialog>
                      <DialogTrigger asChild>
                        <TrashIcon className="cursor-pointer" />
                      </DialogTrigger>
                      <DialogContent>
                        <DialogHeader>
                          <DialogTitle className="text-red-500">
                            Excluir Veiculo
                          </DialogTitle>
                          <DialogDescription>
                            Tem certeza que deseja excluir esse veiculo?
                          </DialogDescription>
                        </DialogHeader>
                        <DialogFooter>
                          <DialogClose asChild>
                            <Button
                              type="submit"
                              onClick={() => handleDelete(vehicle.id as number)}
                            >
                              Sim
                            </Button>
                          </DialogClose>
                          <DialogClose asChild>
                            <Button type="button" variant="destructive">
                              Nao
                            </Button>
                          </DialogClose>
                        </DialogFooter>
                      </DialogContent>
                    </Dialog>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </div>
      </div>
      <ToastContainer />
    </>
  );
}

export default App;

