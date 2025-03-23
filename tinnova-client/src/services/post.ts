import api from "@/api";
import { Vehicle } from "@/domain/vehicle";

export async function postVehicle(vehicle: Vehicle) {
  await api.post("/veiculos", vehicle);
}
