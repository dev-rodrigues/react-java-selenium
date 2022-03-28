import {useQuery} from "react-query";
import {api} from "../api";

type Matriculado = {
    id: number;
    matricula: string;
    nome: string;
    nascimento: string;
    responsavel: string;
};

async function getCandidatos():Promise<Matriculado[]> {
    const { data } = await api.get('/secretaria/');
    console.log(`estou aqui ${data}`);
    return data;
}

export function useCandidatos() {
    return useQuery('matriculados', () =>  getCandidatos());
}
