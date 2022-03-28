import {
    Box,
    Button,
    Divider,
    Flex,
    Heading,
    Stack
} from "@chakra-ui/react";
import {Input} from "../../component/Input";
import {yupResolver} from "@hookform/resolvers/yup";
import * as yup from "yup";
import {SubmitHandler, useForm} from "react-hook-form";
import {useMutation} from "react-query";
import {api} from "../../services/api";
import {queryClient} from "../../index";
import history from "../../history";

type CreateFormData = {
    name: string
    nascimento: Date;
    responsavel: string;
};

const schemaValidation = yup.object().shape({
    nascimento: yup.date().required('Campo obrigatório'),
    responsavel: yup.string(),
    name: yup.string().required('Campo obrigatório'),
});

export function Matricular() {


    const { register, handleSubmit, formState } = useForm({
        resolver: yupResolver(schemaValidation),
    });

    const matricular = useMutation(async (matricula:CreateFormData) => {

        const mes = matricula.nascimento.getMonth() + 1;
        const dia = matricula.nascimento.getDate();
        const ano = matricula.nascimento.getFullYear();

        const nascimento = ano + '-' + mes + '-' + dia;

        const response = api.post('/secretaria/', {
            nome: matricula.name,
            nascimento,
            responsavel: matricula.responsavel,
        })
    }, {
        onSuccess: () => {
            queryClient.invalidateQueries('matriculados');
            history.push('/');
        },
        onError: () => {
            alert('Erro ao matricular');
        }
    })

    const { errors } = formState;

    const handleCreate: SubmitHandler<CreateFormData> = async (values)  => {
        await new Promise(resolve => setTimeout(resolve, 2000));
        await matricular.mutateAsync(values);
    }

    return (
        <Box>
            <Flex w="100%"
                  as="form"
                  my="6"
                  onSubmit={handleSubmit(handleCreate)}
                  maxWidth={1200}
                  mx="auto"
                  px="6">
                <Box flex="1" borderRadius={8} bg="gray.800" p="8">
                    <Flex mb="8" justify="space-between" align="center">
                        <Heading size="lg" fontWeight="normal">
                            Matricular
                        </Heading>

                    </Flex>

                    <Divider my="6" borderColor="gray.700"/>

                    <Stack spacing="8">
                        <Input teste="name"
                               type="text"
                               label="Nome"
                               error={errors.name}
                               {...register('name')}
                        />

                        <Input teste="nascimento"
                               type="date"
                               error={errors.nascimento}
                               {...register('nascimento')}
                               label="Nascimento"/>

                        <Input teste="responsavel"
                               type="text"
                               error={errors.responsavel}
                               {...register('password')}
                               label="Responsável"/>

                        <Button type="submit"
                                marginTop="6"
                                colorScheme="pink"
                                size="lg"
                                isLoading={formState.isSubmitting}>
                            Salvar
                        </Button>

                    </Stack>

                </Box>
            </Flex>
        </Box>
    )
}

export default Matricular;