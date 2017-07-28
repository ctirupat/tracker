import React, { Component } from 'react';
import {Table,TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn} from 'material-ui/Table';
import moment from 'moment';
import axios from 'axios';
class Vehicle extends Component{
    constructor () {
        super();
        this.state={vehicles:[],sortOrder:0}
    }

    componentDidMount(){
        let self=this;
        const vehicleUrl = "http://localhost:8080/api/vehicles";
        axios.get(vehicleUrl)
            .then(function (response) {
                self.setState({
                    vehicles: response.data
                });

            })
            .catch(function (error) {
                console.log(error);
            });
    }
    render(){
        return(
            <div>
                <h1>Vehicle Details</h1>
                <Table>
                    <TableHeader>
                        <TableRow>
                            <TableHeaderColumn>VIN</TableHeaderColumn>
                            <TableHeaderColumn>MAKE</TableHeaderColumn>
                            <TableHeaderColumn>MODEL</TableHeaderColumn>
                            <TableHeaderColumn>YEAR</TableHeaderColumn>
                            <TableHeaderColumn>RED LINE RPM</TableHeaderColumn>
                            <TableHeaderColumn>LAST SERVICE DATE</TableHeaderColumn>
                            <TableHeaderColumn onClick={() =>
                            {
                                console.log("Clicked");
                                this.setState({sortOrder: this.state.sortOrder + 1})
                            }}>NUMBER OF HIGH ALERTS IN LAST 2 HOURS</TableHeaderColumn>
                            <TableHeaderColumn>  </TableHeaderColumn>
                        </TableRow>
                    </TableHeader>
                    <TableBody>
                        {
                            this.state.vehicles.sort((vehicle1,vehicle2)=>{
                                if(this.state.sortOrder%2)
                                    return parseInt(vehicle1.highAlertsCount,10)-parseInt(vehicle2.highAlertsCount,10);
                                else
                                    return parseInt(vehicle2.highAlertsCount,10)-parseInt(vehicle1.highAlertsCount,10);
                            })
                                .map((vehicle,i)=>
                            <TableRow key={i}>
                                <TableRowColumn>{vehicle.vin}</TableRowColumn>
                                <TableRowColumn>{vehicle.make}</TableRowColumn>
                                <TableRowColumn>{vehicle.model}</TableRowColumn>
                                <TableRowColumn>{vehicle.year}</TableRowColumn>
                                <TableRowColumn>{vehicle.redlineRpm}</TableRowColumn>
                                <TableRowColumn>{moment(vehicle.lastServiceDate).format('YYYY-MM-DD HH:mm:ss')}</TableRowColumn>
                                <TableRowColumn>{vehicle.highAlertsCount}</TableRowColumn>
                                <TableRowColumn><a href={"/alerts/"+vehicle.vin}>Details</a></TableRowColumn>
                            </TableRow>

                            )}
                    </TableBody>
                </Table>
            </div>
        );
    }
}
export default Vehicle;