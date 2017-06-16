#! /usr/bin/env ruby

require 'rubygems'
require 'mqtt'

input_array = ARGV

if input_array.length == 3
  MQTT::Client.connect(input_array[0]) do |c|
    c.publish(input_array[1], input_array[2])
  end
else
  puts 'not enough arguments! need server, topic and payload'
end
