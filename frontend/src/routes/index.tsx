import { Route, Switch } from "react-router-dom";

import Candidatos from "../pages/Alunos";
import Matricular from '../pages/Matricular/Index';

export default function Routes() {
    return (
        <Switch>
            <Route path="/" exact component={Candidatos}/>
            <Route path="/matricular" component={Matricular}/>
        </Switch>
    )
}