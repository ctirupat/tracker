import React, { Component } from 'react';
import {Table,TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn} from 'material-ui/Table';
import moment from 'moment';
import axios from 'axios';
import {Tabs, Tab} from 'material-ui/Tabs';
import injectTapEventPlugin from 'react-tap-event-plugin';
import Map from '../Map/Map';
import Reading from "../Reading/Reading";
const styles = {
    headline: {
        fontSize: 24,
        paddingTop: 16,
        marginBottom: 12,
        fontWeight: 400,
    },
};
class Alert extends Component{
    constructor (props) {
        super();
        injectTapEventPlugin();
        this.state={alerts:[], vin:props.match.params.vin}
    }

    componentDidMount(){
        let self=this;
        let vin=self.props.match.params.vin;
        const alertUrl = 'http://localhost:8080/api/alerts/'+ vin;
        axios.get(alertUrl)
            .then(function (response) {
                self.setState({
                    alerts: response.data,
                    vin:vin
                });

            })
            .catch(function (error) {
                console.log(error);
            });
    }

    render(){
        return(
            <div>
                <Tabs>
                    <Tab label="Alerts">
                        <div>
                            <h3><center>Vehicle Alerts</center><b></b></h3>
                            <Table>
                                <TableHeader>
                                    <TableRow>
                                        <TableHeaderColumn>VIN</TableHeaderColumn>
                                        <TableHeaderColumn>Time Stamp</TableHeaderColumn>
                                        <TableHeaderColumn>Alert Type</TableHeaderColumn>
                                    </TableRow>
                                </TableHeader>
                                <TableBody>
                                    {

                                        this.state.alerts.map((alert,i)=>
                                                <TableRow key={i}>
                                                    <TableRowColumn>{alert.vin}</TableRowColumn>
                                                    <TableRowColumn>{moment(alert.lastServiceDate).format('YYYY-MM-DD HH:mm:ss')}</TableRowColumn>
                                                    <TableRowColumn>{alert.priority}</TableRowColumn>
                                                </TableRow>

                                            )}
                                </TableBody>
                            </Table>
                        </div>
                    </Tab>
                    <Tab label="Location" >
                        <div>
                            <h3><center>Location</center><b></b></h3>

                                <Map name={this.state.vin}></Map>

                        </div>
                    </Tab>
                    <Tab label="Analytics">
                        <div>
                            <h3><center>Analytics</center><b></b></h3>
                            <Reading name={this.state.vin}></Reading>
                        </div>
                    </Tab>
                </Tabs>
            </div>

        );
    }
}
export default Alert;