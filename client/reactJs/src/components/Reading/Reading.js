import React, { Component } from 'react';
import {Table,TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn} from 'material-ui/Table';
import moment from 'moment';
import {Gmaps, Marker} from 'react-gmaps';
import axios from 'axios';
import { LineChart, Line, CartesianGrid, ResponsiveContainer, Tooltip, XAxis, YAxis, Legend} from 'recharts';
import './Reading.css';

class Reading extends Component{
    constructor (props) {
        super();
        this.state={data:[]};
    }
    getInitialState() {
        return {
            data:[]
        }
    }



    componentDidMount(){
        let self=this;
        let vin=this.props.name;
        let temp1=[] ;
        let temp2=[] ;
        let temp3=[] ;
        let points=[];
        const readingUrl = 'http://localhost:8080/api/readings/'+ vin;
        axios.get(readingUrl)
            .then(function (response) {
                console.log(response.data);
                response.data.map((reading,i)=>{

                        points.push({xaxis:moment(reading.timestamp).format('YYYY-MM-DD HH:mm:ss'),
                            speed:reading.speed,
                            rpm:reading.engineRpm,
                            volume:reading.fuelVolume});


                })
                self.setState({
                    data:points
                });
                console.log(self.state.data);

            })
            .catch(function (error) {
                console.log(error);
            });

    }
    render(){
        return (
            <div className="graph">
                    <ResponsiveContainer>
                        <LineChart width={600} height={300} data={this.state.data}
                                   margin={{top: 5, right: 30, left: 20, bottom: 5}}>
                            <XAxis dataKey="xaxis"/>
                            <YAxis/>
                            <CartesianGrid strokeDasharray="3 3"/>
                            <Tooltip/>
                            <Legend />
                            <Line type="bitone" dataKey="speed" stroke="#8884d8" activeDot={{r: 8}}/>
                        </LineChart>
                    </ResponsiveContainer>
                    <ResponsiveContainer>
                        <LineChart width={600} height={300} data={this.state.data}
                                   margin={{top: 5, right: 30, left: 20, bottom: 5}}>
                            <XAxis dataKey="xaxis"/>
                            <YAxis/>
                            <CartesianGrid strokeDasharray="3 3"/>
                            <Tooltip/>
                            <Legend />
                            <Line type="bitone" dataKey="rpm" stroke="#8845d8" activeDot={{r: 8}}/>
                        </LineChart>
                    </ResponsiveContainer>
                    <ResponsiveContainer>
                        <LineChart width={600} height={300} data={this.state.data}
                                   margin={{top: 5, right: 30, left: 20, bottom: 5}}>
                            <XAxis dataKey="xaxis"/>
                            <YAxis/>
                            <CartesianGrid strokeDasharray="3 3"/>
                            <Tooltip/>
                            <Legend />
                            <Line type="bitone" dataKey="volume" stroke="#8524d8" activeDot={{r: 8}}/>
                        </LineChart>
                    </ResponsiveContainer>

            </div>
        );
    }
}
export default Reading;