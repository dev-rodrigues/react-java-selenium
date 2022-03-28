import {
    Box, Button,
    Flex,
    Heading, Icon,
    Spinner,
    Table,
    Tbody,
    Td,
    Text,
    Th,
    Thead,
    Tr,
} from "@chakra-ui/react";

import {useCandidatos} from "../../services/hooks/useCandidatos";
import { Link } from "react-router-dom"
import {RiPencilFill} from "react-icons/all";

export default function Candidatos() {
    const { data, isLoading, isFetching, error} = useCandidatos();

    return (
        <Box>
            <Flex w="100%" my="6" maxWidth={1200} mx="auto" px="6">

                <Box flex="1" borderRadius={8} bg="gray.800" p="8">
                    <Flex mb="8" justify="space-between" align="center">
                        <Heading size="lg"
                                 fontWeight="normal">
                            Matriculados
                            { !isLoading && isFetching && <Spinner size="sm" color="gray.500" ml="4"/> }
                        </Heading>
                        <Box>
                            <Link to={'/matricular'}>
                                <Button as="a" size="sm" fontSize="sm" colorScheme="purple" leftIcon={<Icon as={RiPencilFill}/>}>
                                    Matricular
                                </Button>
                            </Link>

                        </Box>
                    </Flex>

                    { isLoading ? (
                        <Flex justify="center">
                            <Spinner />
                        </Flex>
                    ) : error ? (
                        <Flex justify="center">
                            <Text>Falha ao obter dados dos matriculados</Text>
                        </Flex>
                    ) : (
                        <>
                            <Table colorScheme="whiteAlpha" id="matriculados">
                                <Thead>
                                    <Th>
                                        Matricula
                                    </Th>
                                    <Th>
                                        Nome
                                    </Th>
                                    <Th>
                                        Nascimento
                                    </Th>

                                    <Th>
                                        Responsável
                                    </Th>
                                </Thead>
                                <Tbody>
                                    { data?.map(matriculado => {
                                        return (
                                            <Tr key={matriculado.id}>
                                                <Td>
                                                    <Box>
                                                        { matriculado.matricula === 'PRIMARIO' && (
                                                            <Text fontWeight="bold" color="pink.500">{matriculado.matricula}</Text>
                                                        )}
                                                        { matriculado.matricula === 'UNIVERSITARIO' && (
                                                            <Text fontWeight="bold" color="blue.400">{matriculado.matricula}</Text>
                                                        )}
                                                    </Box>
                                                </Td>

                                                <Td>
                                                    <Box>
                                                        <Text fontWeight="bold">{matriculado.nome}</Text>
                                                    </Box>
                                                </Td>

                                                <Td>
                                                    <Box>
                                                        <Text fontWeight="bold">{matriculado.nascimento}</Text>
                                                    </Box>
                                                </Td>

                                                <Td>
                                                    <Box>
                                                        <Text fontWeight="bold">{matriculado.responsavel}</Text>
                                                    </Box>
                                                </Td>
                                            </Tr>
                                        )
                                    })}
                                </Tbody>
                            </Table>
                        </>
                    )}
                </Box>
            </Flex>
        </Box>
    );
}
