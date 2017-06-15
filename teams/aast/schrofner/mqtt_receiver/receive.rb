#! /usr/bin/env ruby

require 'rubygems'
require 'mqtt'

input_array = ARGV

if input_array.length == 2
  MQTT::Client.connect(input_array[0]) do |c|
    c.subscribe(input_array[1])

    c.get do |topic,message|
      puts topic + ":"  + message
    end
  end
else
  puts 'not enough arguments! need server and topic'
end
